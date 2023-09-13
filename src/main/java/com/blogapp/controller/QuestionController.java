package com.blogapp.controller;

import com.blogapp.dto.QuestionDTO;
import com.blogapp.dto.converter.QuestionDTOConverter;
import com.blogapp.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        return ResponseEntity.ok(questionDTOConverter.getListOfQuestionDTOFromListOfQuestion(questionService.getAllQuestion()));
    }

    @PostMapping("/ask")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<QuestionDTO> askQuestion(@RequestBody QuestionDTO questionDTO) {
        questionService.updateQuestion(questionDTOConverter.getQuestionFromQuestionDTO(questionDTO));
        return ResponseEntity.ok(questionDTO);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(questionDTOConverter.getQuestionDTOFromQuestion(questionService.getQuestionById(id)));
    }
}
