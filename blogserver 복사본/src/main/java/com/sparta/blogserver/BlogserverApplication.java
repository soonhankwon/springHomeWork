package com.sparta.blogserver;

import com.sparta.blogserver.domain.Memo;
import com.sparta.blogserver.dto.MemoRequestDto;
import com.sparta.blogserver.repository.MemoRepository;
import com.sparta.blogserver.service.MemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
@EnableJpaAuditing
@SpringBootApplication
public class BlogserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogserverApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MemoRepository memoRepository) {
        return (args) -> {
            memoRepository.save(new Memo("타이틀3","유저네임3","컨텐츠3","1234")); //데이터 저장하기
            System.out.println("데이터 인쇄");
//            List<Memo> memoList = memoRepository.findAll(); //데이터 전부 조회하기
//            for (int i = 0; i < memoList.size(); i++) {
//                Memo memo = memoList.get(i);
//                System.out.println(memo.getId());
//                System.out.println(memo.getTitle());
//                System.out.println(memo.getUsername());
//                System.out.println(memo.getContents());
//                System.out.println(memo.getPassword());
//            }
        };
    }
}

