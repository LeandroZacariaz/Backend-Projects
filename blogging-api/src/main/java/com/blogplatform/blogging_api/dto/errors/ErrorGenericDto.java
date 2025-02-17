package com.blogplatform.blogging_api.dto.errors;

import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar errores genéricos")
public record ErrorGenericDto(
    @Schema(description = "Mensaje principal del error")
    String message, 
    @Schema(description = "Lista de errores detallados")
    List<Map<String, String>> errors) {

}
