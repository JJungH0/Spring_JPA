package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Locker {
    @Id
    private long id;

    @Setter
    @NotNull
    private String name;

    @OneToOne
    private Member member;

    public void setMember(Member member) {
        this.member = member;
        member.setLocker(this);
    }
}
