package com.nathaliamello.gitflowdemo.user.controller;

import com.nathaliamello.gitflowdemo.common.response.ApiResponse;
import com.nathaliamello.gitflowdemo.user.dto.CreateUserDTO;
import com.nathaliamello.gitflowdemo.user.dto.UserOutputDTO;
import com.nathaliamello.gitflowdemo.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserOutputDTO>> getUserById(@PathVariable Long id) {
        ApiResponse<UserOutputDTO> response = userService.getUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserOutputDTO>> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        ApiResponse<UserOutputDTO> response = userService.createUser(createUserDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
