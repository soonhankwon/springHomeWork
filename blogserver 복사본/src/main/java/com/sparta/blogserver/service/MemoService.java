package com.sparta.blogserver.service;

import com.sparta.blogserver.domain.Memo;
//import com.sparta.blogserver.dto.CheckResponse;
import com.sparta.blogserver.dto.CheckResponseDto;
import com.sparta.blogserver.dto.GetListDto;
import com.sparta.blogserver.dto.MemoRequestDto;
import com.sparta.blogserver.dto.MemoResponseDto;
import com.sparta.blogserver.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto findById(Long id) {
        Memo entity = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 없습니다. id="+id)
        );
            return new MemoResponseDto(entity);
    }

    public void update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
    }
    public CheckResponseDto checkPassword(Long id, MemoRequestDto requestDto) {
        // 메모를 찾아옴 없다면 예외처리
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다."));
        // 찾아온 메모의 비밀번호가 요청받은 리퀘스트디티오의 비밀번호와 일치하는지 검증함
        if(memo.getPassword().equals(requestDto.getPassword())) {
            // 일치한다면 체크리스폰스디티오를 successs로 반환함
            return new CheckResponseDto(true);
        } else {
            // 그렇지 않다면 success를 false로 반환함
            return new CheckResponseDto(false);
        }
    }
//    public void insert(MemoRequestDto requestDto) {
//        Memo memo = new Memo(requestDto);
//        memoRepository.save(memo);
//    }
}

