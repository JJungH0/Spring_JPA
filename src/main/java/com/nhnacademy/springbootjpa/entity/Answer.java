package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

// TODO #2: `answer` 테이블과 매핑될 `Answer` Entity 클래스를 작성하세요.
/*
 * create table answer
 * (
 *     id          bigint auto_increment
 *         primary key,
 *     question_id bigint   not null,
 *     content     text     not null,
 *     created_at  datetime not null
 * );
 */
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id")
    @NotNull
    private Long questionId;

    @NotNull
    private String content;

    @Column(name = "created_at")
    @NotNull
    private ZonedDateTime createdAt;

    public Answer(long questionId, String content, ZonedDateTime createdAt) {
        this.questionId = questionId;
        this.content = content;
        this.createdAt = createdAt;
    }

}
