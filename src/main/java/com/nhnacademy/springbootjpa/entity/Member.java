package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.concurrent.locks.Lock;

// TODO #2: `Member` Entity에서 연관 관계 삭제
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    private long id;

    @Setter
    @NotNull
    private String name;

    @OneToOne(mappedBy = "member")
    private Locker locker;
}
