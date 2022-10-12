package com.assignment.postblog.dto;

import com.assignment.postblog.model.Post;
import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String author;
    private String content;

    public PostRequestDto (Post post) {
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content = post.getContent();
    }
}
