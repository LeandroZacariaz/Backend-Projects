package com.blogplatform.blogging_api.service.category;

import java.util.List;

import com.blogplatform.blogging_api.domain.Category;
import com.blogplatform.blogging_api.dto.category.CategoryCreateDto;
import com.blogplatform.blogging_api.dto.category.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryCreateDto categoryCreateDto);
    List<CategoryDto> getAllCategory();
    void deleteCategory(Long id_category);
    Category getCategoryById(Long id_category);
    Category getCategoryByName(String name);
}
