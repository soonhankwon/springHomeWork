package com.assignment.postblog.dto;

import com.assignment.postblog.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostInfoResponseDto {
    private long id;
    private String title;
    private String content;

    public PostInfoResponseDto (Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
