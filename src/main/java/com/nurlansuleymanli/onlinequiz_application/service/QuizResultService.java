package com.nurlansuleymanli.onlinequiz_application.service;

import com.nurlansuleymanli.onlinequiz_application.dto.AnswerDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizResultResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizSubmitRequest;
import com.nurlansuleymanli.onlinequiz_application.entity.OptionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuestionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuizEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuizResultEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.UserEntity;
import com.nurlansuleymanli.onlinequiz_application.mapper.QuizResultMapper;
import com.nurlansuleymanli.onlinequiz_application.repository.OptionRepository;
import com.nurlansuleymanli.onlinequiz_application.repository.QuizRepository;
import com.nurlansuleymanli.onlinequiz_application.repository.QuizResultRepository;
import com.nurlansuleymanli.onlinequiz_application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizResultService {

    private final QuizResultRepository quizResultRepository;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final OptionRepository optionRepository;
    private final QuizResultMapper quizResultMapper;

    @Transactional
    public QuizResultResponseDto submitQuiz(Long quizId, QuizSubmitRequest request) {
        UserEntity user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));

        QuizEntity quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + quizId));

        int totalQuestions = quiz.getQuestions() != null ? quiz.getQuestions().size() : 0;
        int correctAnswers = 0;

        if (totalQuestions > 0 && request.getAnswers() != null) {
            Map<Long, QuestionEntity> questionMap = quiz.getQuestions().stream()
                    .collect(Collectors.toMap(QuestionEntity::getId, q -> q));

            for (AnswerDto answer : request.getAnswers()) {
                QuestionEntity question = questionMap.get(answer.getQuestionId());
                if (question != null && answer.getSelectedOptionId() != null) {
                    OptionEntity selectedOption = optionRepository.findById(answer.getSelectedOptionId()).orElse(null);
                    if (selectedOption != null
                            && selectedOption.getQuestion() != null
                            && selectedOption.getQuestion().getId().equals(question.getId())
                            && selectedOption.isCorrect()) {
                        correctAnswers++;
                    }
                }
            }
        }

        double score = totalQuestions > 0
                ? Math.round(((double) correctAnswers / totalQuestions) * 100.0 * 10.0) / 10.0
                : 0.0;

        QuizResultEntity result = quizResultRepository.findByUserIdAndQuizId(user.getId(), quiz.getId())
                .map(existing -> {
                    existing.setTotalQuestions(totalQuestions);
                    existing.setCorrectAnswers(correctAnswers);
                    existing.setScore(score);
                    return existing;
                })
                .orElseGet(() -> QuizResultEntity.builder()
                        .user(user)
                        .quiz(quiz)
                        .totalQuestions(totalQuestions)
                        .correctAnswers(correctAnswers)
                        .score(score)
                        .build());

        QuizResultEntity savedResult = quizResultRepository.save(result);
        return quizResultMapper.toDto(savedResult);
    }

    @Transactional(readOnly = true)
    public List<QuizResultResponseDto> getUserResults(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        return quizResultRepository.findByUserId(userId)
                .stream()
                .map(quizResultMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<QuizResultResponseDto> getQuizResults(Long quizId) {
        if (!quizRepository.existsById(quizId)) {
            throw new RuntimeException("Quiz not found with id: " + quizId);
        }
        return quizResultRepository.findByQuizId(quizId)
                .stream()
                .map(quizResultMapper::toDto)
                .toList();
    }
}
