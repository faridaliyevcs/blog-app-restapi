package com.blogapp.dto.converter;

import com.blogapp.dto.ReplyDTO;
import com.blogapp.entity.Reply;
import com.blogapp.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReplyDTOConverter {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private QuestionDTOConverter questionDTOConverter;

    public Reply getReplyFromReplyDTO(ReplyDTO from) {
        return new Reply(from.getId(),
                from.getContent(),
                userDTOConverter.getUserFromDTO(from.getUserDTO()),
                questionDTOConverter.getQuestionFromQuestionDTO(from.getQuestionDTO()));
    }

    public ReplyDTO getReplyDTOFromReply(Reply from) {
        return new ReplyDTO(from.getId(),
                from.getContent(),
                userDTOConverter.getUserDTOFromEntity(from.getUser()),
                questionDTOConverter.getQuestionDTOFromQuestion(from.getQuestion()));
    }

    public List<Reply> getListOfReplyFromListOfReplyDTO(List<ReplyDTO> from) {
        if (from == null) {
            return Collections.emptyList();
        }
        return from.stream().map(reply->getReplyFromReplyDTO(reply)).collect(Collectors.toList());
    }

    public List<ReplyDTO> getListOfReplyDTOFromListOfReply(List<Reply> from) {
        if (from == null) {
            return Collections.emptyList();
        }
        return from.stream().map(reply->getReplyDTOFromReply(reply)).collect(Collectors.toList());
    }


}
