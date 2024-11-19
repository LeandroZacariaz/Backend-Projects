package com.blogplatform.blogging_api.dto.post;

import java.time.LocalDateTime;
import java.util.List;

import com.blogplatform.blogging_api.dto.category.CategoryDto;
import com.blogplatform.blogging_api.dto.tag.TagDto;

public record PostDto(
    Long id_post,
    String title,
    String content,
    CategoryDto category,
    List<TagDto> tags,
    LocalDateTime createAt,
    LocalDateTime updateAt
) {

}
