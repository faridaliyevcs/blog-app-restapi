package com.blogapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDTO {

    private Integer id;

    private UserDTO user;

    private EntryDTO entryDTO;

}
