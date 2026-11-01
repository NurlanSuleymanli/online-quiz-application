package com.nurlansuleymanli.onlinequiz_application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizSubmitRequest {

    @NotNull
    Long userId;

    @NotEmpty
    List<AnswerDto> answers;
}
