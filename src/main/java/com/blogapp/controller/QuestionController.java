package com.blogapp.controller;

import com.blogapp.dto.QuestionDTO;
import com.blogapp.dto.converter.QuestionDTOConverter;
import com.blogapp.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private QuestionDTOConverter questionDTOConverter;

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        return ResponseEntity.ok(questionDTOConverter.getListOfQuestionDTOFromListOfQuestion(questionService.getAllQuestion()));
    }

    @PostMapping("/ask")
    public ResponseEntity<QuestionDTO> askQuestion(@RequestBody QuestionDTO questionDTO) {
        questionService.updateQuestion(questionDTOConverter.getQuestionFromQuestionDTO(questionDTO));
        return ResponseEntity.ok(questionDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(questionDTOConverter.getQuestionDTOFromQuestion(questionService.getQuestionById(id)));
    }
}
