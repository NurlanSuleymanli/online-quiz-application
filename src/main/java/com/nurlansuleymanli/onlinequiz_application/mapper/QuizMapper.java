package com.nurlansuleymanli.onlinequiz_application.mapper;

import com.nurlansuleymanli.onlinequiz_application.dto.OptionResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuestionResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizDetailResponseDto;
import com.nurlansuleymanli.onlinequiz_application.dto.QuizResponseDto;
import com.nurlansuleymanli.onlinequiz_application.entity.OptionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuestionEntity;
import com.nurlansuleymanli.onlinequiz_application.entity.QuizEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class QuizMapper {

    public QuizResponseDto toQuizResponseDto(QuizEntity quiz) {
        if (quiz == null) {
            return null;
        }
        return QuizResponseDto.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .quizDescription(quiz.getQuizDescription())
                .totalQuestions(quiz.getQuestions() != null ? quiz.getQuestions().size() : 0)
                .build();
    }

    public QuizDetailResponseDto toQuizDetailResponseDto(QuizEntity quiz) {
        if (quiz == null) {
            return null;
        }
        List<QuestionResponseDto> questionDtos = quiz.getQuestions() != null
                ? quiz.getQuestions().stream().map(this::toQuestionResponseDto).toList()
                : Collections.emptyList();

        return QuizDetailResponseDto.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .quizDescription(quiz.getQuizDescription())
                .totalQuestions(questionDtos.size())
                .questions(questionDtos)
                .build();
    }

    public QuestionResponseDto toQuestionResponseDto(QuestionEntity question) {
        if (question == null) {
            return null;
        }
        List<OptionResponseDto> optionDtos = question.getOptions() != null
                ? question.getOptions().stream().map(this::toOptionResponseDto).toList()
                : Collections.emptyList();

        return QuestionResponseDto.builder()
                .id(question.getId())
                .questionText(question.getQuestionText())
                .options(optionDtos)
                .build();
    }

    public OptionResponseDto toOptionResponseDto(OptionEntity option) {
        if (option == null) {
            return null;
        }
        return OptionResponseDto.builder()
                .id(option.getId())
                .optionText(option.getOptionText())
                .build();
    }
}
