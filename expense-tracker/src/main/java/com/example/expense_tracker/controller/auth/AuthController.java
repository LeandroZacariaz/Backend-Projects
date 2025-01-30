package com.example.expense_tracker.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.dto.auth.AuthResponseDto;
import com.example.expense_tracker.dto.user.UserLoginDto;
import com.example.expense_tracker.dto.user.UserRegisterDto;
import com.example.expense_tracker.service.auth.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid UserLoginDto userLoginDto){
        return ResponseEntity.ok(authService.login(userLoginDto));
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody @Valid UserRegisterDto userRegisterDto){
        return ResponseEntity.ok(authService.register(userRegisterDto));
    }
}
