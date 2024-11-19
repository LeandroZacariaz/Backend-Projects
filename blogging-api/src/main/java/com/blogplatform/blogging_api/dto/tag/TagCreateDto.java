package com.blogplatform.blogging_api.dto.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TagCreateDto(
    @NotNull(message = "The tag name cannot be null.")
    @NotBlank(message = "The tag name cannot be empty.")
    String name
) {

}
