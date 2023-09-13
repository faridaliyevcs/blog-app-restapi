package com.blogapp.controller;

import com.blogapp.dto.ReplyDTO;
import com.blogapp.dto.converter.QuestionDTOConverter;
import com.blogapp.dto.converter.ReplyDTOConverter;
import com.blogapp.service.impl.QuestionServiceImpl;
import com.blogapp.service.impl.ReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyDTOConverter replyDTOConverter;

    @Autowired
    private QuestionDTOConverter questionDTOConverter;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private ReplyServiceImpl replyService;

    @PostMapping("/{id}/reply")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReplyDTO> replyQuestion(@RequestBody ReplyDTO replyDTO,
                                                  @PathVariable(name = "id") Integer id) {
        replyDTO.setQuestionDTO(questionDTOConverter.getQuestionDTOFromQuestion(questionService.getQuestionById(id)));
        replyService.updateReply(replyDTOConverter.getReplyFromReplyDTO(replyDTO));
        return ResponseEntity.ok(replyDTO);
    }

    @PostMapping("/{id}/delete")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReplyDTO> deleteReply(@PathVariable(name = "id") Integer replyId) {
        replyService.deleteReplyById(replyId);
        return new ResponseEntity<>(replyDTOConverter.getReplyDTOFromReply(replyService.getReplyById(replyId)), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReplyDTO> updateReply(@PathVariable(name = "id") Integer replyId,
                                                @RequestBody ReplyDTO replyDTO) {
        replyDTO.setId(replyId);
        replyService.updateReply(replyDTOConverter.getReplyFromReplyDTO(replyDTO));
        return new ResponseEntity<>(replyDTOConverter.getReplyDTOFromReply(replyService.getReplyById(replyId)), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ReplyDTO>> getAllRepliesByQuestionId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(replyDTOConverter.getListOfReplyDTOFromListOfReply(questionService.getQuestionById(id).getReplies()));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReplyDTO> getReplyByReplyId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(replyDTOConverter.getReplyDTOFromReply(replyService.getReplyById(id)));
    }

}
