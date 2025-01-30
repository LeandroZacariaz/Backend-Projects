package com.example.expense_tracker.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.dto.user.UserDto;
import com.example.expense_tracker.mappers.user.UserMapper;
import com.example.expense_tracker.service.user.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private UserMapper userMapper;
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id_user){
        UserDto userDto=userMapper.UserToUserDto(userService.getUserById(id_user));
        return ResponseEntity.ok().body(userDto);
    }
}
