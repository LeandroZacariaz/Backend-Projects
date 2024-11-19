package com.blogplatform.blogging_api.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogplatform.blogging_api.domain.Category;
import com.blogplatform.blogging_api.dto.category.CategoryCreateDto;
import com.blogplatform.blogging_api.dto.category.CategoryDto;
import com.blogplatform.blogging_api.exceptions.ResourceNotFoundException;
import com.blogplatform.blogging_api.mappers.category.CategoryMapper;
import com.blogplatform.blogging_api.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryCreateDto categoryCreateDto){
        Category categoryCreated = categoryMapper.categoryCreateDtoToCategory(categoryCreateDto);
        return categoryMapper.categoryToCategoryDto(categoryRepository.save(categoryCreated));
    }

    @Override
    public List<CategoryDto> getAllCategory(){
        return categoryRepository.findAll().stream().map(c -> categoryMapper.categoryToCategoryDto(c)).toList();
    }

    @Override
    public Category getCategoryById(Long id_category){
        return categoryRepository.findById(id_category)
                .orElseThrow(() -> new ResourceNotFoundException("The category with id: " + id_category + " does not exist."));
    }

    @Override
    public void deleteCategory(Long id_category){
        if (categoryRepository.existsById(id_category)) {
            categoryRepository.deleteById(id_category);;
        }else{
            throw new ResourceNotFoundException("The category with id:" + id_category + " does not exist.");
        }
    }

    @Override 
    public Category getCategoryByName(String name){
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("The category with name: " + name + " does not exist."));
    }
}
