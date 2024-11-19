package com.blogplatform.blogging_api.service.tag;

import com.blogplatform.blogging_api.domain.Tag;
import com.blogplatform.blogging_api.dto.tag.TagCreateDto;
import com.blogplatform.blogging_api.dto.tag.TagDto;

public interface TagService {
    TagDto createTag(TagCreateDto tagCreateDto);
    Tag getTagById(Long id_tag);
    Tag getTagByName(String name);
}
