package com.assignment.postblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class CommonResponse<T> {

    private T result;

    public CommonResponse(T data) {
        this.result = data;
    }
    //result를 List 형태로 반환
    @Getter
    @NoArgsConstructor
    public static class ofList<T> {
        private List<T> result;
        public ofList(List<T> data) {
            this.result = data;
        }
    }
}
