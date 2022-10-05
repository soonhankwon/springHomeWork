package com.sparta.blogserver.controller;

import com.sparta.blogserver.domain.Memo;
import com.sparta.blogserver.dto.CheckResponseDto;
import com.sparta.blogserver.dto.GetListDto;
import com.sparta.blogserver.dto.MemoRequestDto;
import com.sparta.blogserver.dto.MemoResponseDto;
import com.sparta.blogserver.repository.MemoRepository;
import com.sparta.blogserver.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")  //게시글 작성
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        //Memo 클래스의 createMemo 메소드
        Memo memo = new Memo(requestDto); //Memo 생성자 호출
        return memoRepository.save(memo);
    }

    @PostMapping("/api/memos/{id}")  //비밀번호확인
    public CheckResponseDto checkPassword(@PathVariable Long id, MemoRequestDto requestDto) {
        //CheckResponseDto 클래스의 checkPassword 메소드
        return this.memoService.checkPassword(id, requestDto);
        //memoService의 메소드를 통해 checkPassword(id,requestDto) 값을 리턴해줌
    }

    //    @GetMapping("/api/memos") //전체 게시글 목록 조회
//    public GetListDto getMemos() {
//        return memoService.searchByAll();
//}
    @GetMapping("/api/memos") //전체 게시글 목록 조회
    public List<Memo> getMemo() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

//    @GetMapping("/api/memos") //전체 게시글 목록 조회
//    public List<Memo> getMemos() {
//        return memoRepository.findAllByOrderByModifiedAtDesc();
//    }

////        return memoRepository.findByIdAndTitleAndUsername(id, requestDto.getTitle(), requestDto.getUsername());

//    @GetMapping("/api/memos")  //  전체 목록 조회 (아이디,타이틀,이름)
//    public MemoResponseDto getLIst() {return memoService.getList();}

    @GetMapping("/api/memos/{id}")  //  게시글 조회
    public MemoResponseDto findById(@PathVariable Long id) {
        return memoService.findById(id);
    }
    //MemoResponseDto 클래스에서 findById 메소드만들어줌, @PathVariable Long id값을 변수로받고, 리턴값으로 메모서비스의 findById메소드실행

    @DeleteMapping("/api/memos/{id}") //게시글 삭제
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}") //게시글 수정
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }
}
