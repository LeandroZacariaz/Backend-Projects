package com.blogplatform.blogging_api.dto.post;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PostCreateDto(
    @NotNull(message = "The post title cannot be null.")
    @NotBlank(message = "The post title cannot be empty.")
    String title,
    @NotNull(message = "The post content cannot be null.")
    @NotBlank(message = "The post content cannot be empty.")
    String content,
    @NotNull(message = "The category name cannot be null.")
    @NotBlank(message = "The category name cannot be empty.")
    String name_category,
    @NotNull(message = "The tag names cannot be null.")
    @NotEmpty(message = "The tag names cannot be empty.")
    List<String> name_tags
) {

}
