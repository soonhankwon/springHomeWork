package com.sparta.blogserver.dto;

import lombok.Getter;

@Getter
public class CheckResponseDto {  //CheckResponseDto 클래스 선언
    private Boolean success; //필드값
    private Boolean data;
    private String error;

    public CheckResponseDto(boolean success){  //CheckResponseDto 생성자 생성 (boolean success)의 매개변수를 가진
        //if(success) 라면 success, data, error의 인스턴스 변수를 (해당값으로) 초기화시켜줌
        if(success){
            this.success = true;
            this.data = true;
            this.error = null;
        } else {
            this.success = false;
            this.data = false;
            this.error = "비밀번호가 일치하지 않습니다.";
        }
    }
}
