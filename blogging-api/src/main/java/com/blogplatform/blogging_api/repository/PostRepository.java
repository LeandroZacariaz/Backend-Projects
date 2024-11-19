package com.blogplatform.blogging_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogplatform.blogging_api.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
