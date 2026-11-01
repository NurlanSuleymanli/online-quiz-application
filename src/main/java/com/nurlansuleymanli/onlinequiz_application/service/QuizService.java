package com.nurlansuleymanli.onlinequiz_application.service;

import com.nurlansuleymanli.onlinequiz_application.dto.QuizDetailResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizResponseDto;
import com.nurlansuleymanli.onlinequiz_application.entity.QuizEntity;
import com.nurlansuleymanli.onlinequiz_application.mapper.QuizMapper;
import com.nurlansuleymanli.onlinequiz_application.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    @Transactional(readOnly = true)
    public List<QuizResponseDto> getAllQuizzes() {
        return quizRepository.findAll()
                .stream()
                .map(quizMapper::toQuizResponseDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public QuizDetailResponseDto getQuizById(Long id) {
        QuizEntity quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
        return quizMapper.toQuizDetailResponseDto(quiz);
    }
}
