package com.nurlansuleymanli.onlinequiz_application.mapper;

import com.nurlansuleymanli.onlinequiz_application.dto.UserResponseDto;
import com.nurlansuleymanli.onlinequiz_application.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(UserEntity user) {
        if (user == null) {
            return null;
        }
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
