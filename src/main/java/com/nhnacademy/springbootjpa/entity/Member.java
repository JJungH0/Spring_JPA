package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

// TODO #1: `Member` Entity에 양방향 연관 관계 설정
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
    // mappedBy -> 관계를 소유하는 필드 지정(애는 주인이 아님)
    private Locker locker;

    public void setLocker(Locker locker) {
        this.locker = locker;

        if (locker.getMember() != null) {
            locker.setMember(this);
        }

    }
}
