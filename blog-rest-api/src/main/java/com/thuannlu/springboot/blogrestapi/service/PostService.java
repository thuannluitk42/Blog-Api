package com.thuannlu.springboot.blogrestapi.service;


import com.thuannlu.springboot.blogrestapi.payload.PostDto;
import com.thuannlu.springboot.blogrestapi.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
}
