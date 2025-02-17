package com.blogplatform.blogging_api.dto.post;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para la creación de una publicación")
public record PostCreateDto(
    @NotNull(message = "The post title cannot be null.")
    @NotBlank(message = "The post title cannot be empty.")
    @Schema(description = "Título de la publicación", example = "Cómo aprender Java en 30 días")
    String title,
    @NotNull(message = "The post content cannot be null.")
    @NotBlank(message = "The post content cannot be empty.")
    @Schema(description = "Contenido de la publicación", example = "Este post explica cómo aprender Java en un mes...")
    String content,
    @NotNull(message = "The category name cannot be null.")
    @NotBlank(message = "The category name cannot be empty.")
    @Schema(description = "Nombre de la categoría de la publicación", example = "Programación")
    String name_category,
    @NotNull(message = "The tag names cannot be null.")
    @NotEmpty(message = "The tag names cannot be empty.")
    @NotNull @Schema(description = "Lista de nombres de etiquetas asociadas a la publicación")
    List<String> name_tags
) {

}
