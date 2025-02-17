package com.blogplatform.blogging_api.dto.tag;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para la creación de una etiqueta")
public record TagCreateDto(
    @NotNull 
    @NotBlank
    @Schema(description = "Nombre de la etiqueta", example = "Java")
    String name
) {}
