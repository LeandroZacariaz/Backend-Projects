package com.example.todolist_api2.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserLoginDto(
    @NotNull(message = "The user email cannot be null.")
    @NotBlank(message = "The user email cannot be empty.")
    String email,
    @NotNull(message = "The user password cannot be null.")
    @NotBlank(message = "The user password cannot be empty.")
    String password
) {

}
