package com.blogplatform.blogging_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogplatform.blogging_api.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    Optional<Category> findByName(String name);
}
