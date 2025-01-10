package com.example.todolist_api2.controller.user;

import com.example.todolist_api2.dto.user.UserDto;
import com.example.todolist_api2.mappers.user.UserMapper;
import com.example.todolist_api2.service.user.UserService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/user"})
@AllArgsConstructor
public class UserController {
   private UserMapper userMapper;
   private UserService userService;

   @GetMapping({"/{id}"})
   public ResponseEntity<?> getUserById(@PathVariable("id") Long id_user) {
      UserDto user = this.userMapper.UserToUserDto(this.userService.getUserById(id_user));
      return ResponseEntity.ok().body(user);
   }

}
