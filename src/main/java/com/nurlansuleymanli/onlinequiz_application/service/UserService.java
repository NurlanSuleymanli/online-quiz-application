package com.nurlansuleymanli.onlinequiz_application.service;

import com.nurlansuleymanli.onlinequiz_application.dto.LoginRequest;
import com.nurlansuleymanli.onlinequiz_application.dto.UserResponseDto;
import com.nurlansuleymanli.onlinequiz_application.entity.UserEntity;
import com.nurlansuleymanli.onlinequiz_application.exception.ResourceNotFoundException;
import com.nurlansuleymanli.onlinequiz_application.mapper.UserMapper;
import com.nurlansuleymanli.onlinequiz_application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserResponseDto login(LoginRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseGet(() -> {
                    String name = request.getFullName();
                    if (name == null || name.isBlank()) {
                        name = request.getEmail().split("@")[0];
                    }
                    UserEntity newUser = UserEntity.builder()
                            .email(request.getEmail().trim().toLowerCase())
                            .fullName(name)
                            .build();
                    return userRepository.save(newUser);
                });

        return userMapper.toDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toDto(user);
    }
}
