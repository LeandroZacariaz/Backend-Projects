package com.example.expense_tracker.dto.auth;

import lombok.Builder;

@Builder
public record AuthResponseDto(String token) {

}
