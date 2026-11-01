package entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "options")
public class OptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "option_text")
    String optionText;

    @Column(name = "is_correct")
    boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    QuestionEntity question;


    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;

}
