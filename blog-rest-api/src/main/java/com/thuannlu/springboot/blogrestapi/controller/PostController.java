package com.thuannlu.springboot.blogrestapi.controller;

import com.thuannlu.springboot.blogrestapi.payload.PostDto;
import com.thuannlu.springboot.blogrestapi.payload.PostResponse;
import com.thuannlu.springboot.blogrestapi.service.PostService;
import com.thuannlu.springboot.blogrestapi.untils.AppConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "CRUD Rest APIs for Post resources")
@RestController
@RequestMapping()
public class PostController {

    @Autowired
    private PostService postService;

    // create blog post rest api
    @ApiOperation(value = "Create Post REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/v1/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts rest api
    @ApiOperation(value = "Get All Posts REST API")
    @GetMapping("/api/v1/posts")
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // get post by id
    @ApiOperation(value = "Get Post By Id REST API")
    @GetMapping(value = "/api/v1/posts/{id}")
    public ResponseEntity<PostDto> getPostByIdV1(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // thay doi version api cach 2: bang cach them chu v2
    // get post by id
//    @GetMapping(value = "/api/v2/posts/{id}")
//    public ResponseEntity<PostDto2> getPostByIdV2(@PathVariable(name = "id") long id) {
//        PostDto postDto = postService.getPostById(id);
//        PostDto2 postDto2 = new PostDto2();
//        postDto2.setId(postDto.getId());
//        postDto2.setTitle(postDto.getTitle());
//        postDto2.setDescription(postDto.getDescription());
//        postDto2.setContent(postDto.getContent());
//
//        List<String> tags = new ArrayList<>();
//        tags.add("Java");
//        tags.add("Springboot");
//        tags.add("AWS");
//
//        postDto2.setTags(tags);
//
//        return ResponseEntity.ok(postDto2);
//    }

    // Thay doi version api cach 3: them params
    // get post by id
//    @GetMapping(value = "/api/posts/{id}", params = "version=3")
//    public ResponseEntity<PostDto3> getPostByIdV3(@PathVariable(name = "id") long id){
//        PostDto postDto = postService.getPostById(id);
//        PostDto3 postDto3 = new PostDto3();
//        postDto3.setId(postDto.getId());
//        postDto3.setTitle(postDto3.getTitle());
//        postDto3.setDescription(postDto3.getDescription());
//        postDto3.setContent(postDto3.getContent());
//
//        List<String> tags = new ArrayList<>();
//        tags.add("Java");
//        tags.add("Springboot");
//        tags.add("AWS");
//
//        postDto3.setType(tags);
//
//        return ResponseEntity.ok(postDto3);
//    }

    // thay doi version api cach 4: them param headers
//     //get post by id
//    @GetMapping(value = "/api/posts/{id}", headers = "X-API-VERSION=4")
//    public ResponseEntity<PostDto3> getPostByIdV3(@PathVariable(name = "id") long id){
//        PostDto postDto = postService.getPostById(id);
//        PostDto3 postDto3 = new PostDto3();
//        postDto3.setId(postDto.getId());
//        postDto3.setTitle(postDto.getTitle());
//        postDto3.setDescription(postDto.getDescription());
//        postDto3.setContent(postDto.getContent());
//
//        List<String> tags = new ArrayList<>();
//        tags.add("Java");
//        tags.add("Springboot");
//        tags.add("AWS");
//
//        postDto3.setType(tags);
//
//        return ResponseEntity.ok(postDto3);
//    }

    // thay doi version api cach thu 5: them parama producer
    //get post by id
//    @GetMapping(value = "/api/posts/{id}", produces = "application/vnd.thuannlu.v1+json")
//    public ResponseEntity<PostDto3> getPostByIdV3(@PathVariable(name = "id") long id){
//        PostDto postDto = postService.getPostById(id);
//        PostDto3 postDto3 = new PostDto3();
//        postDto3.setId(postDto.getId());
//        postDto3.setTitle(postDto.getTitle());
//        postDto3.setDescription(postDto.getDescription());
//        postDto3.setContent(postDto.getContent());
//
//        List<String> tags = new ArrayList<>();
//        tags.add("Java");
//        tags.add("Springboot");
//        tags.add("AWS");
//
//        postDto3.setType(tags);
//
//        return ResponseEntity.ok(postDto3);
//    }

    // update post by id rest api
    @ApiOperation(value = "Update Post By Id REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // delete post rest api
    @ApiOperation(value = "Delete Post By Id REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }

}
