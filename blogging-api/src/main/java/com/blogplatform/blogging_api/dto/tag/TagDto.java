package com.blogplatform.blogging_api.dto.tag;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar una etiqueta sin usar la entidad directamente")
public record TagDto(
    @Schema(description = "Identificador único de la etiqueta", example = "1")
    Long id_tag,

    @Schema(description = "Nombre de la etiqueta", example = "Java")
    String name
) {}
