package com.blogapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryDTO {

    private Integer id;

    private UserDTO user;

    private Integer likes;

    private HeaderDTO header;

    private String content;

    private Date date;

}
