package com.blogplatform.blogging_api.dto.errors;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar un error cuando un recurso no se encuentra")
public record ErrorDtoNotFound(
        @Schema(description = "Ruta de la solicitud que generó el error")
        String path,

        @Schema(description = "Mensaje de error")
        String message) {

}
