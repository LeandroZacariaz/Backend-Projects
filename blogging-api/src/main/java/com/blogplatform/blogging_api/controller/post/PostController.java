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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
public class PostController {
    private PostService postService;
    private PostMapper postMapper;

    @PostMapping()
    public ResponseEntity<?> createPost(@Valid @RequestBody PostCreateDto postCreateDto){
        PostDto postCreatedDto =  postService.createPost(postCreateDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(postCreatedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable("id") Long id_post, @Valid @RequestBody PostCreateDto postCreateDto){
        PostDto postUpdated = postService.updatePost(id_post, postCreateDto);

        return ResponseEntity.ok().body(postUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id_post){
        postService.deletePost(id_post);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable ("id") Long id_post){
        PostDto postDto = postMapper.postToPostDto(postService.getPostById(id_post));
        return ResponseEntity.ok().body(postDto);
    }

    @GetMapping()
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }
}
