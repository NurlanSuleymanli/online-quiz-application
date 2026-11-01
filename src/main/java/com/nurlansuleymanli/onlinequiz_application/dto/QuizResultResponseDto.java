package com.nurlansuleymanli.onlinequiz_application.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizResultResponseDto {
    Long id;
    Long userId;
    String userEmail;
    Long quizId;
    String quizName;
    int totalQuestions;
    int correctAnswers;
    double score;
    LocalDateTime submittedAt;
}
