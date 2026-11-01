package com.nurlansuleymanli.onlinequiz_application.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizDetailResponseDto {
    Long id;
    String name;
    String quizDescription;
    int totalQuestions;
    List<QuestionResponseDto> questions;
}
