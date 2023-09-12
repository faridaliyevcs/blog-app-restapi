package com.blogapp.service.inter;

import com.blogapp.entity.Question;

import java.util.List;

public interface QuestionServiceInter {

    List<Question> getAllQuestion();

    Question getQuestionById(int id);

    void deleteQuestionById(int id);

    void updateQuestion(Question question);

}
