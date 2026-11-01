package com.nurlansuleymanli.onlinequiz_application.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_results")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    QuizEntity quiz;

    @Column(name = "total_questions", nullable = false)
    int totalQuestions;

    @Column(name = "correct_answers", nullable = false)
    int correctAnswers;

    @Column(name = "score", nullable = false)
    double score;

    @Column(name = "submitted_at", updatable = false)
    @CreationTimestamp
    LocalDateTime submittedAt;
}
