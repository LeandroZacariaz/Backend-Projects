package com.example.todolist_api2.controller.auth;


import com.example.todolist_api2.dto.auth.AuthResponseDto;
import com.example.todolist_api2.dto.user.UserLoginDto;
import com.example.todolist_api2.dto.user.UserRegisterDto;
import com.example.todolist_api2.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/auth"})
@AllArgsConstructor
public class AuthController {
   private final AuthService authService;

   @PostMapping({"login"})
   public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid UserLoginDto userLoginDto) {
      return ResponseEntity.ok(this.authService.login(userLoginDto));
   }

   @PostMapping({"register"})
   public ResponseEntity<AuthResponseDto> register(@RequestBody @Valid UserRegisterDto userRegisterDto) {
      return ResponseEntity.ok(this.authService.register(userRegisterDto));
   }

}