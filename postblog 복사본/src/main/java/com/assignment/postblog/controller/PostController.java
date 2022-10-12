package com.assignment.postblog.controller;

import com.assignment.postblog.dto.CommonResponse;
import com.assignment.postblog.dto.PostInfoResponseDto;
import com.assignment.postblog.dto.PostRequestDto;
import com.assignment.postblog.model.Post;
import com.assignment.postblog.repository.PostRepository;
import com.assignment.postblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/auth/post")  //게시글 작성
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        //Post 클래스의 createPost 메소드
        Post post = new Post(requestDto); //Post 생성자 호출
        return postRepository.save(post);
    }
    @GetMapping("/post") //게시글 조회
    public CommonResponse.ofList getPostList() {
        List<PostRequestDto> postRequestDtoList = postService.findAllPost();
        return new CommonResponse.ofList(postRequestDtoList);
    }
    @GetMapping("/post/{id}") //게시글 상세 조회
    public CommonResponse getPostInfo(@PathVariable Long id) {
        PostInfoResponseDto postInfoResponseDto = postService.findPost(id);
        return new CommonResponse(postInfoResponseDto);
    }
    @PutMapping("auth/post/{id}") //게시글 수정
    public Long updatePost (@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
        // why return id?
    }
    @DeleteMapping("/auth/post/{id}") //게시글 삭제
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }
}
