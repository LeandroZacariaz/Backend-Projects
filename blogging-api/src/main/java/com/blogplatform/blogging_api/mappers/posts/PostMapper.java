package com.blogplatform.blogging_api.mappers.posts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blogplatform.blogging_api.domain.Post;
import com.blogplatform.blogging_api.dto.post.PostCreateDto;
import com.blogplatform.blogging_api.dto.post.PostDto;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id_post", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(source = "name_category", target = "category.name")
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    Post postCreateDtoToPost(PostCreateDto postDto);

    PostDto postToPostDto(Post post);

}
