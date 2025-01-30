package com.example.expense_tracker.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterDto(
    @NotNull(message = "The user name cannot be null.")
    @NotBlank(message = "The user name cannot be empty.")
    String name,
    @NotNull(message = "The user email cannot be null.")
    @NotBlank(message = "The user email cannot be empty.")
    @Email(message = "The user email must be a valid email address.")
    String email,
    @NotNull(message = "The user password cannot be null.")
    @NotBlank(message = "The user password cannot be empty.")
    String password
) {

}
