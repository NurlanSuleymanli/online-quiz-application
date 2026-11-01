package com.nurlansuleymanli.onlinequiz_application.repository;

import com.nurlansuleymanli.onlinequiz_application.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<OptionEntity, Long> {
    List<OptionEntity> findByQuestionId(Long questionId);
}
