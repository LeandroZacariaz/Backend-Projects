package com.blogplatform.blogging_api.service.post;

import java.util.List;

import com.blogplatform.blogging_api.domain.Post;
import com.blogplatform.blogging_api.dto.post.PostCreateDto;
import com.blogplatform.blogging_api.dto.post.PostDto;

public interface PostService {
    PostDto createPost(PostCreateDto postCreateDto);
    Post getPostById(Long id_post);
    PostDto updatePost(Long id_post, PostCreateDto postCreateDto);
    void deletePost(Long id_post);
    List<PostDto> getAllPosts();
}
