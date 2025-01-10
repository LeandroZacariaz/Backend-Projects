package com.example.todolist_api2.dto.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ToDoCreateDto(
    @NotNull(message = "The to-do title cannot be null.")
    @NotBlank(message = "The to-do title cannot be empty.")
    String title,
    @NotNull(message = "The to-do description cannot be null.")
    @NotBlank(message = "The to-do description cannot be empty.")
    String description
) {

}
