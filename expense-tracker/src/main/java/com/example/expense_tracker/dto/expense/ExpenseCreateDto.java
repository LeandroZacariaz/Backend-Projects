package com.example.expense_tracker.dto.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ExpenseCreateDto(
    @NotNull(message = "The expense name cannot be null.")
    @NotBlank(message = "The expense name cannot be empty.")
    String name,
    @NotNull(message = "The expense description cannot be null.")
    @NotBlank(message = "The expense description cannot be empty.")
    String description,
    @NotNull(message = "The expense amount cannot be null.")
    @Positive(message = "The expense amount must be positive.")
    Double amount,
    @NotNull(message = "The category name cannot be null.")
    @NotBlank(message = "The category name cannot be empty.")
    String name_category
) {

}
