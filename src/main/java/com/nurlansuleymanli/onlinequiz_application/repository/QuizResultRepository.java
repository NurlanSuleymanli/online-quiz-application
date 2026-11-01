package com.nurlansuleymanli.onlinequiz_application.repository;

import com.nurlansuleymanli.onlinequiz_application.entity.QuizResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizResultRepository extends JpaRepository<QuizResultEntity, Long> {
    List<QuizResultEntity> findByUserId(Long userId);
    List<QuizResultEntity> findByQuizId(Long quizId);
    Optional<QuizResultEntity> findByUserIdAndQuizId(Long userId, Long quizId);
}
