package com.example.todolist_api2.dto.auth;

import lombok.Builder;

@Builder
public record AuthResponseDto(String token) {

}
