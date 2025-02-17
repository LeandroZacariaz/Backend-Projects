package com.blogplatform.blogging_api.controller.post;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogplatform.blogging_api.dto.post.PostCreateDto;
import com.blogplatform.blogging_api.dto.post.PostDto;
import com.blogplatform.blogging_api.mappers.posts.PostMapper;
import com.blogplatform.blogging_api.service.post.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
@Tag(name = "Posts", description = "Operaciones relacionadas con los posts")
public class PostController {
    private PostService postService;
    private PostMapper postMapper;

    @Operation(summary = "Crear un nuevo post", description = "Crea un post con título, contenido y categorías especificadas")
    @ApiResponse(responseCode = "201", description = "Post creado exitosamente")
    @PostMapping()
    public ResponseEntity<?> createPost(@Valid @RequestBody PostCreateDto postCreateDto){
        PostDto postCreatedDto =  postService.createPost(postCreateDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(postCreatedDto);
    }

    @Operation(summary = "Actualizar un post", description = "Actualiza el contenido de un post existente por ID")
    @ApiResponse(responseCode = "200", description = "Post actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Post no encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@Parameter(description = "ID del post a actualizar") @PathVariable("id") Long id_post, @Valid @RequestBody PostCreateDto postCreateDto){
        PostDto postUpdated = postService.updatePost(id_post, postCreateDto);

        return ResponseEntity.ok().body(postUpdated);
    }

    @Operation(summary = "Eliminar un post", description = "Elimina un post específico por su ID")
    @ApiResponse(responseCode = "204", description = "Post eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Post no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@Parameter(description = "ID del post a eliminar") @PathVariable("id") Long id_post){
        postService.deletePost(id_post);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Obtener un post por ID", description = "Devuelve un post específico con su contenido y detalles")
    @ApiResponse(responseCode = "200", description = "Post obtenido exitosamente")
    @ApiResponse(responseCode = "404", description = "Post no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@Parameter(description = "ID del post a obtener") @PathVariable ("id") Long id_post){
        PostDto postDto = postMapper.postToPostDto(postService.getPostById(id_post));
        return ResponseEntity.ok().body(postDto);
    }

    @Operation(summary = "Obtener todos los posts", description = "Devuelve una lista de todos los posts existentes")
    @ApiResponse(responseCode = "200", description = "Lista de posts obtenida exitosamente")
    @GetMapping()
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }
}
