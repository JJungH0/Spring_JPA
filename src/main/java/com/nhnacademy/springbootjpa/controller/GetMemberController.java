package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.Member;
import com.nhnacademy.springbootjpa.entity.MemberNameOnlyView;
import com.nhnacademy.springbootjpa.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetMemberController {

    private final MemberRepository memberRepository;
    // TODO #1: `GET /members?page=2&size=3` 와 같은 요청을 처리하도록 아래 코드를 완성하세요.
    @GetMapping("/members")
    public Page<MemberNameOnlyView> findAll(@PageableDefault Pageable pageable) {
        return memberRepository.findAllBy(pageable);
    }

    // 500 -> 에러발생
    // 세션이 닫힌 뒤에 지연 로딩(LAZY fetch) 컬렉션에 접근해서 생기는 문제
//    @GetMapping("/members")
//    public Page<Member> findAll(Pageable pageable) {
//        return memberRepository.findAll(pageable);
//    }
}
