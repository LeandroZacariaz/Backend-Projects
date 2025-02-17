package com.blogplatform.blogging_api.controller.tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogplatform.blogging_api.dto.tag.TagCreateDto;
import com.blogplatform.blogging_api.dto.tag.TagDto;
import com.blogplatform.blogging_api.service.tag.TagService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/tag")
@AllArgsConstructor
@Tag(name = "Tags", description = "Operaciones relacionadas con los tags")
public class TagController {
    private TagService tagService;

    @Operation(summary = "Crear un nuevo tag", description = "Crea un tag con el nombre especificado")
    @ApiResponse(responseCode = "201", description = "Tag creado exitosamente")
    @PostMapping()
    public ResponseEntity<?> createTag(@Valid @RequestBody TagCreateDto tagCreateDto){
        TagDto tagDto = tagService.createTag(tagCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tagDto);
    }
}
