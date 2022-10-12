package com.assignment.postblog.service;

import com.assignment.postblog.dto.DBEmptyDataException;
import com.assignment.postblog.dto.PostInfoResponseDto;
import com.assignment.postblog.dto.PostRequestDto;
import com.assignment.postblog.model.Member;
import com.assignment.postblog.model.Post;
import com.assignment.postblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public List<PostRequestDto> findAllPost() {
        try {
            List<Post> postList = postRepository.findAll();
            //Java Stream 사용
            List<PostRequestDto> postRequestDtoList = postList.stream().map(PostRequestDto::new).collect(Collectors.toList());
            return postRequestDtoList;
        } catch (Exception e) {
            throw new DBEmptyDataException("글 목록 조회 실패");
        }
    }
    public PostInfoResponseDto findPost(Long id) {
        Post findPost = postRepository.findById(id).orElseThrow(() -> {
            throw new DBEmptyDataException("글 상세 조회 실패");
        });
        PostInfoResponseDto postInfoResponseDto = new PostInfoResponseDto(findPost);
        return postInfoResponseDto;
    }
    public void update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        post.update(requestDto);
    }
}
