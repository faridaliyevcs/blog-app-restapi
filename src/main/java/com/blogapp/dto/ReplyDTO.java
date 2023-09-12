package com.blogapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {

    private Integer id;

    private String content;

    private UserDTO userDTO;

    private QuestionDTO questionDTO;

}
