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
@NoArgsConstructor
public class Answer {
    public Answer(long questionId, String content, ZonedDateTime createdAt) {
        this.questionId = questionId;
        this.content = content;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,name = "question_id")
    private Long questionId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, updatable = false, name = "created_at")
    private ZonedDateTime createdAt;


}
