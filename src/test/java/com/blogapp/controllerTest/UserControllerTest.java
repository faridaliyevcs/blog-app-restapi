package com.blogapp.controllerTest;

import com.blogapp.controller.UserController;
import com.blogapp.dto.UserDTO;
import com.blogapp.dto.converter.UserDTOConverter;
import com.blogapp.entity.User;
import com.blogapp.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    UserServiceImpl userService;

    @Mock
    UserDTOConverter userDTOConverter;

    @InjectMocks
    UserController userController;

    @Test
    void shouldRegisterSuccessfully(){
//        UserDTO userDTO = new UserDTO(1, "admin", "admin","admin@gmail.com", null,null);
//        User user = new User(1,"admin", "admin", "admin@gmail.com", null,null);
//        Mockito.when(userDTOConverter.getUserFromDTO(ArgumentMatchers.any(UserDTO.class))).thenReturn(user);
//        Mockito.when(userService.updateNewUser(ArgumentMatchers.any(User.class))).thenReturn(user);
//        //ResponseEntity<UserDTO> responseEntity = userController.registerUser(userDTO);
//        Mockito.verify(userService, Mockito.times(1)).updateNewUser(ArgumentMatchers.argThat(savedUser -> savedUser.getUsername().equals("admin")));
//        Assertions.assertSame(HttpStatus.OK, responseEntity.getStatusCode());
//        Assertions.assertSame(userDTO, responseEntity.getBody());
    }
}
