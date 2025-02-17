package com.blogplatform.blogging_api.dto.post;

import java.time.LocalDateTime;
import java.util.List;

import com.blogplatform.blogging_api.dto.category.CategoryDto;
import com.blogplatform.blogging_api.dto.tag.TagDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar una publicación sin usar la entidad directamente")
public record PostDto(
    @Schema(description = "Identificador único de la publicación", example = "1")
    Long id_post,

    @Schema(description = "Título de la publicación", example = "Cómo aprender Java en 30 días")
    String title,

    @Schema(description = "Contenido de la publicación", example = "Este post explica cómo aprender Java en un mes...")
    String content,

    @Schema(description = "Categoría a la que pertenece la publicación")
    CategoryDto category,

    @Schema(description = "Lista de etiquetas asociadas a la publicación")
    List<TagDto> tags,

    @Schema(description = "Fecha de creación de la publicación", example = "2024-02-09T12:00:00")
    LocalDateTime createAt,

    @Schema(description = "Fecha de última actualización de la publicación", example = "2024-02-10T14:30:00")
    LocalDateTime updateAt
) {

}
