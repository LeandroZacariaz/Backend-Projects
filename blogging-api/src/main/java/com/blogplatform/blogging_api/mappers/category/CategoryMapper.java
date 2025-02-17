package com.blogplatform.blogging_api.mappers.category;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blogplatform.blogging_api.domain.Category;
import com.blogplatform.blogging_api.dto.category.CategoryCreateDto;
import com.blogplatform.blogging_api.dto.category.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id_category", ignore = true)
    @Mapping(target = "posts", ignore = true)
    Category categoryCreateDtoToCategory(CategoryCreateDto categoryDto);

    CategoryDto categoryToCategoryDto(Category category);
    
    //CategoryDto categoryToCategoryDto(Category category);
}
