package com.nurlansuleymanli.onlinequiz_application.config;

import com.nurlansuleymanli.onlinequiz_application.entity.OptionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuestionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuizEntity;
import com.nurlansuleymanli.onlinequiz_application.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final QuizRepository quizRepository;

    @Override
    public void run(String... args) {
        if (quizRepository.count() > 0) {
            return;
        }

        QuizEntity javaQuiz = QuizEntity.builder()
                .name("Java Fundamentals")
                .quizDescription("Test your core Java knowledge and OOP concepts.")
                .build();

        QuestionEntity q1 = QuestionEntity.builder()
                .questionText("What is the size of an int data type in Java?")
                .quiz(javaQuiz)
                .build();

        OptionEntity q1o1 = OptionEntity.builder().optionText("8 bits").correct(false).question(q1).build();
        OptionEntity q1o2 = OptionEntity.builder().optionText("16 bits").correct(false).question(q1).build();
        OptionEntity q1o3 = OptionEntity.builder().optionText("32 bits").correct(true).question(q1).build();
        OptionEntity q1o4 = OptionEntity.builder().optionText("64 bits").correct(false).question(q1).build();
        q1.setOptions(List.of(q1o1, q1o2, q1o3, q1o4));

        QuestionEntity q2 = QuestionEntity.builder()
                .questionText("Which keyword is used to inherit a class in Java?")
                .quiz(javaQuiz)
                .build();

        OptionEntity q2o1 = OptionEntity.builder().optionText("implements").correct(false).question(q2).build();
        OptionEntity q2o2 = OptionEntity.builder().optionText("extends").correct(true).question(q2).build();
        OptionEntity q2o3 = OptionEntity.builder().optionText("inherits").correct(false).question(q2).build();
        OptionEntity q2o4 = OptionEntity.builder().optionText("super").correct(false).question(q2).build();
        q2.setOptions(List.of(q2o1, q2o2, q2o3, q2o4));

        QuestionEntity q3 = QuestionEntity.builder()
                .questionText("Which of the following is NOT a primitive data type in Java?")
                .quiz(javaQuiz)
                .build();

        OptionEntity q3o1 = OptionEntity.builder().optionText("int").correct(false).question(q3).build();
        OptionEntity q3o2 = OptionEntity.builder().optionText("boolean").correct(false).question(q3).build();
        OptionEntity q3o3 = OptionEntity.builder().optionText("String").correct(true).question(q3).build();
        OptionEntity q3o4 = OptionEntity.builder().optionText("char").correct(false).question(q3).build();
        q3.setOptions(List.of(q3o1, q3o2, q3o3, q3o4));

        javaQuiz.setQuestions(List.of(q1, q2, q3));
        quizRepository.save(javaQuiz);

        QuizEntity springQuiz = QuizEntity.builder()
                .name("Spring Boot Basics")
                .quizDescription("Test your understanding of Spring Boot fundamentals.")
                .build();

        QuestionEntity sq1 = QuestionEntity.builder()
                .questionText("Which annotation combines @Configuration, @EnableAutoConfiguration, and @ComponentScan?")
                .quiz(springQuiz)
                .build();

        OptionEntity sq1o1 = OptionEntity.builder().optionText("@SpringApplication").correct(false).question(sq1).build();
        OptionEntity sq1o2 = OptionEntity.builder().optionText("@SpringBootApplication").correct(true).question(sq1).build();
        OptionEntity sq1o3 = OptionEntity.builder().optionText("@EnableSpring").correct(false).question(sq1).build();
        OptionEntity sq1o4 = OptionEntity.builder().optionText("@BootApplication").correct(false).question(sq1).build();
        sq1.setOptions(List.of(sq1o1, sq1o2, sq1o3, sq1o4));

        QuestionEntity sq2 = QuestionEntity.builder()
                .questionText("What is the default embedded web server in Spring Boot?")
                .quiz(springQuiz)
                .build();

        OptionEntity sq2o1 = OptionEntity.builder().optionText("Tomcat").correct(true).question(sq2).build();
        OptionEntity sq2o2 = OptionEntity.builder().optionText("Jetty").correct(false).question(sq2).build();
        OptionEntity sq2o3 = OptionEntity.builder().optionText("Undertow").correct(false).question(sq2).build();
        OptionEntity sq2o4 = OptionEntity.builder().optionText("Netty").correct(false).question(sq2).build();
        sq2.setOptions(List.of(sq2o1, sq2o2, sq2o3, sq2o4));

        springQuiz.setQuestions(List.of(sq1, sq2));
        quizRepository.save(springQuiz);
    }
}
