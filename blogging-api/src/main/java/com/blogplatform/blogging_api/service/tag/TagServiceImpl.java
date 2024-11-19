package com.blogplatform.blogging_api.service.tag;

import org.springframework.stereotype.Service;

import com.blogplatform.blogging_api.domain.Tag;
import com.blogplatform.blogging_api.dto.tag.TagCreateDto;
import com.blogplatform.blogging_api.dto.tag.TagDto;
import com.blogplatform.blogging_api.exceptions.ResourceNotFoundException;
import com.blogplatform.blogging_api.mappers.tag.TagMapper;
import com.blogplatform.blogging_api.repository.TagRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService{
    private TagRepository tagRepository;
    private TagMapper tagMapper;

    @Override
    public TagDto createTag (TagCreateDto tagCreateDto){
        Tag tagCreated = tagMapper.tagCreateDtoToTag(tagCreateDto); 
        return tagMapper.tagToTagDto(tagRepository.save(tagCreated));
    }

    @Override
    public Tag getTagById(Long id_tag){
        return tagRepository.findById(id_tag)
            .orElseThrow(() -> new ResourceNotFoundException("The post with id: "+id_tag+" does not exist."));
    }

    @Override
    public Tag getTagByName(String name){
        return tagRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("The post with name: "+name+" does not exist."));
    }
}
