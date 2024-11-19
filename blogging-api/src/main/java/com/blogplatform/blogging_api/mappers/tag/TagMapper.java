package com.blogplatform.blogging_api.mappers.tag;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blogplatform.blogging_api.domain.Tag;
import com.blogplatform.blogging_api.dto.tag.TagCreateDto;
import com.blogplatform.blogging_api.dto.tag.TagDto;

@Mapper(componentModel = "spring")
public interface TagMapper {
    @Mapping(target = "id_tag", ignore = true)
    Tag tagCreateDtoToTag(TagCreateDto tagCreateDto);

    TagDto tagToTagDto(Tag tag);
}
