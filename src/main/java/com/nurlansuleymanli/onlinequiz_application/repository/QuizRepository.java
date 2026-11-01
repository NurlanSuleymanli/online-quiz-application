package com.nurlansuleymanli.onlinequiz_application.repository;

import com.nurlansuleymanli.onlinequiz_application.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
}
