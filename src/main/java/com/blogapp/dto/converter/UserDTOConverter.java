package com.blogapp.dto.converter;

import com.blogapp.dto.UserDTO;
import com.blogapp.entity.User;
import com.blogapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikeDTOConverter likeDTOConverter;


    public User getUserFromDTO(UserDTO from) {
        return new User(from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getEmail(),
                from.getBirthDate(),
                likeDTOConverter.getListOfLikeFromListOfLikeDTO(from.getLikes()));
    }

    public UserDTO getUserDTOFromEntity(User from) {
        return new UserDTO(from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getEmail(),
                from.getBirthDate(),
                likeDTOConverter.getListOfLikeDTOFromListOfLike(from.getLikes()));
    }


}
