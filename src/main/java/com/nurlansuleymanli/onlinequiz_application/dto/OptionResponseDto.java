package com.nurlansuleymanli.onlinequiz_application.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OptionResponseDto {
    Long id;
    String optionText;
}
