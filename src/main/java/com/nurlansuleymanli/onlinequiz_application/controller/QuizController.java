package com.nurlansuleymanli.onlinequiz_application.controller;

import com.nurlansuleymanli.onlinequiz_application.dto.QuizDetailResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizResultResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizSubmitRequest;
import com.nurlansuleymanli.onlinequiz_application.service.QuizResultService;
import com.nurlansuleymanli.onlinequiz_application.service.QuizService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final QuizResultService quizResultService;

    @GetMapping
    public ResponseEntity<List<QuizResponseDto>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDetailResponseDto> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<QuizResultResponseDto> submitQuiz(
            @PathVariable Long id,
            @Valid @RequestBody QuizSubmitRequest request) {
        return ResponseEntity.ok(quizResultService.submitQuiz(id, request));
    }

    @GetMapping("/{id}/results")
    public ResponseEntity<List<QuizResultResponseDto>> getQuizResults(@PathVariable Long id) {
        return ResponseEntity.ok(quizResultService.getQuizResults(id));
    }
}
