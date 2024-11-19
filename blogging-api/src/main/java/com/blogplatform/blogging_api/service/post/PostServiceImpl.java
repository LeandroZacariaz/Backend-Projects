package com.blogplatform.blogging_api.service.post;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blogplatform.blogging_api.domain.Category;
import com.blogplatform.blogging_api.domain.Post;
import com.blogplatform.blogging_api.domain.Tag;
import com.blogplatform.blogging_api.dto.post.PostCreateDto;
import com.blogplatform.blogging_api.dto.post.PostDto;
import com.blogplatform.blogging_api.exceptions.ResourceNotFoundException;
import com.blogplatform.blogging_api.mappers.posts.PostMapper;
import com.blogplatform.blogging_api.repository.PostRepository;
import com.blogplatform.blogging_api.service.category.CategoryService;
import com.blogplatform.blogging_api.service.tag.TagService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{
    private PostMapper postMapper;
    private PostRepository postRepository;
    private CategoryService categoryService;
    private TagService tagService;

    @Override
    public PostDto createPost(PostCreateDto postCreateDto){
        Post postCreated = postMapper.postCreateDtoToPost(postCreateDto);
        postCreated.setCreateAt(LocalDateTime.now());
        postCreated.setUpdateAt(LocalDateTime.now());

        Category category = categoryService.getCategoryByName(postCreateDto.name_category());
        
        postCreated.setCategory(category);

        List<Tag> tags = postCreateDto.name_tags().stream().map(t -> tagService.getTagByName(t)).toList();
        postCreated.setTags(tags);

        return postMapper.postToPostDto(postRepository.save(postCreated));
    }

    @Override
    public PostDto updatePost(Long id_post, PostCreateDto postCreateDto){
        Post postUpdate = getPostById(id_post);
        postUpdate.setTitle(postCreateDto.title());
        postUpdate.setContent(postCreateDto.content());
        postUpdate.setUpdateAt(LocalDateTime.now());

        Category categoryUpdate = categoryService.getCategoryByName(postCreateDto.name_category());
        postUpdate.setCategory(categoryUpdate);


        List<Tag> tagsUpdate = postCreateDto.name_tags().stream().map(t -> tagService.getTagByName(t)).toList();
        postUpdate.getTags().clear();
        postUpdate.getTags().addAll(tagsUpdate);

        return postMapper.postToPostDto(postRepository.save(postUpdate));
    }

    @Override
    public Post getPostById(Long id_post){
        return postRepository.findById(id_post)
            .orElseThrow(() -> new ResourceNotFoundException("The post with id: "+id_post+" does not exist."));
    }

    @Override 
    public void deletePost(Long id_post){
        if (postRepository.existsById(id_post)) {
            postRepository.deleteById(id_post);
        }else{
            throw new ResourceNotFoundException("The post with id: "+id_post+" does not exist.");
        }
    }

    @Override
    public List<PostDto> getAllPosts(){
        return postRepository.findAll().stream().map(p -> postMapper.postToPostDto(p)).toList();
    }

}
