package com.sparta.blogserver.repository;

import com.sparta.blogserver.domain.Memo;
import com.sparta.blogserver.dto.GetListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
//    List<Memo> findByTitleAndUsername(String title, String username); //전체글조회
    List<Memo> findAllByOrderByModifiedAtDesc();
    @Override
    Optional<Memo> findById(Long aLong);   //findById로 게시글 조회
//    @Query("SELECT p From Memo p ORDER BY p.id DESC")
//    List<Memo>findAllDesc();0000

}
