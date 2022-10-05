package com.sparta.blogserver.dto;

import com.sparta.blogserver.domain.Memo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoRequestDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String password;

}
