package com.blogapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Integer id;

    private String content;

    private UserDTO user;

    private List<ReplyDTO> replyDTOList;

    public QuestionDTO(int id, String content) {
        this.id = id;
        this.content = content;
    }

}
