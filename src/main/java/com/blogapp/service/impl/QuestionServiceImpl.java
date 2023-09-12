package com.blogapp.service.impl;

import com.blogapp.entity.Question;
import com.blogapp.repository.QuestionRepository;
import com.blogapp.service.inter.QuestionServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionServiceInter {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(int id) {
        return questionRepository.findById(id);
    }

    @Override
    public void deleteQuestionById(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void updateQuestion(Question question) {
        questionRepository.save(question);
    }
}
