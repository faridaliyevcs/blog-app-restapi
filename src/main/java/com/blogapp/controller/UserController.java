package com.blogapp.controller;

import com.blogapp.dto.UserDTO;
import com.blogapp.dto.converter.UserDTOConverter;
import com.blogapp.entity.AuthRequest;
import com.blogapp.entity.User;
import com.blogapp.security2.JwtService;
import com.blogapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user") // Add a base URL mapping
public class UserController {

    private final UserServiceImpl userService;
    private final UserDTOConverter userDTOConverter;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(
            UserServiceImpl userService,
            UserDTOConverter userDTOConverter,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        User user = userDTOConverter.getUserFromDTO(userDTO);
        userService.updateNewUser(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String getUser() {
        return "hello";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            String token = jwtService.generateToken(authRequest.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
