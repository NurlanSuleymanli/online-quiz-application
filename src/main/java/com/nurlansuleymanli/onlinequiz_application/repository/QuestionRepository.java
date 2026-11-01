package com.nurlansuleymanli.onlinequiz_application.repository;

import com.nurlansuleymanli.onlinequiz_application.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> findByQuizId(Long quizId);
}
