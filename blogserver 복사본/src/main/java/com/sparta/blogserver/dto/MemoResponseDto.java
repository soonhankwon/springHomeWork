package com.sparta.blogserver.dto;

import com.sparta.blogserver.domain.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
//    private String date;

    public MemoResponseDto(Memo responseDto){
        this.id = responseDto.getId();
        this.title = responseDto.getTitle();;
        this.contents = responseDto.getContents();
        this.username = responseDto.getUsername();
//        this.date = entity.getDate();
    }
}
