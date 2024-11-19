package com.blogplatform.blogging_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogplatform.blogging_api.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
    Optional<Tag> findByName(String name);
}
