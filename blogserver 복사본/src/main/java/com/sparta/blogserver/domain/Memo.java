package com.sparta.blogserver.domain;

import com.sparta.blogserver.dto.GetListDto;
import com.sparta.blogserver.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private String password;

    public Memo (String title, String username, String contents, String password) {
        //Memo라는 생성자 (매개변수)
        this.title = title;
        //매개변수 초기화
        this.username = username;
        this.contents = contents;
        this.password = password;
    }

    public Memo(MemoRequestDto requestDto) {
        // Memo 생성자오버로드
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
    public void update(MemoRequestDto requestDto) {
        // update 메소드
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}
