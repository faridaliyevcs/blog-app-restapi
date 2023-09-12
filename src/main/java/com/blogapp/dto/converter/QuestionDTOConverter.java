package com.blogapp.dto.converter;

import com.blogapp.dto.QuestionDTO;
import com.blogapp.entity.Question;
import com.blogapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionDTOConverter {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private ReplyDTOConverter replyDTOConverter;

    public Question getQuestionFromQuestionDTO(QuestionDTO from) {
        return new Question(from.getId(),
                from.getContent(),
                userDTOConverter.getUserFromDTO(from.getUser()),
                replyDTOConverter.getListOfReplyFromListOfReplyDTO(from.getReplyDTOList()));
    }

    public QuestionDTO getQuestionDTOFromQuestion(Question from) {
        return new QuestionDTO(from.getId(),
                from.getContent(),
                userDTOConverter.getUserDTOFromEntity(from.getUser()),
                replyDTOConverter.getListOfReplyDTOFromListOfReply(from.getReplies()));
    }

    public List<QuestionDTO> getListOfQuestionDTOFromListOfQuestion(List<Question> from) {
        return from.stream().map(question -> getQuestionDTOFromQuestion(question)).collect(Collectors.toList());
    }
    public List<Question> getListOfQuestionFromListOfQuestionDTO(List<QuestionDTO> from) {
        return from.stream().map(question -> getQuestionFromQuestionDTO(question)).collect(Collectors.toList());
    }

}
