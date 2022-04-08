package com.thuannlu.springboot.blogrestapi.repository;

import com.thuannlu.springboot.blogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
