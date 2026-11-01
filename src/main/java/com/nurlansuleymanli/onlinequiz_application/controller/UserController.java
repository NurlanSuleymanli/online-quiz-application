package com.nurlansuleymanli.onlinequiz_application.controller;

import com.nurlansuleymanli.onlinequiz_application.dto.QuizResultResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.UserResponseDto;
import com.nurlansuleymanli.onlinequiz_application.service.QuizResultService;
import com.nurlansuleymanli.onlinequiz_application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final QuizResultService quizResultService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/{id}/results")
    public ResponseEntity<List<QuizResultResponseDto>> getUserResults(@PathVariable Long id) {
        return ResponseEntity.ok(quizResultService.getUserResults(id));
    }
}
