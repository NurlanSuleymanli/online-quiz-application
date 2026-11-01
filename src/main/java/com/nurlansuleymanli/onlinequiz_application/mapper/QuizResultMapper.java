package com.nurlansuleymanli.onlinequiz_application.mapper;

import com.nurlansuleymanli.onlinequiz_application.dto.QuizResultResponseDto;
import com.nurlansuleymanli.onlinequiz_application.entity.QuizResultEntity;
import org.springframework.stereotype.Component;

@Component
public class QuizResultMapper {

    public QuizResultResponseDto toDto(QuizResultEntity entity) {
        if (entity == null) {
            return null;
        }
        return QuizResultResponseDto.builder()
                .id(entity.getId())
                .userId(entity.getUser() != null ? entity.getUser().getId() : null)
                .userEmail(entity.getUser() != null ? entity.getUser().getEmail() : null)
                .quizId(entity.getQuiz() != null ? entity.getQuiz().getId() : null)
                .quizName(entity.getQuiz() != null ? entity.getQuiz().getName() : null)
                .totalQuestions(entity.getTotalQuestions())
                .correctAnswers(entity.getCorrectAnswers())
                .score(entity.getScore())
                .submittedAt(entity.getSubmittedAt())
                .build();
    }
}
