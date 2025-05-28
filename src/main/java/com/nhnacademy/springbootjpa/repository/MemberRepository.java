package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Member;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // TODO #1: @EntityGraph를 사용하여 N+1 문제를 해결하세요.
    // 쿼리dsl과 비교하자면
    // 그래프는 -> 런타임시에 오류가 발생할수있고
    // 쿼리dsl -> 컴파일시에 오류를 감지할수있어서 배포 시 에러가 적다.
    @EntityGraph(attributePaths = "locker")
    List<Member> findAllBy();
}
