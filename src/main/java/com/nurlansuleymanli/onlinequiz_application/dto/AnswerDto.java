package com.nurlansuleymanli.onlinequiz_application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerDto {

    @NotNull
    Long questionId;

    @NotNull
    Long selectedOptionId;
}
