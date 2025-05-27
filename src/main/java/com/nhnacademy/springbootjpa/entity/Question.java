package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

// TODO #1: `question` 테이블과 매핑될 `Question` Entity 클래스를 작성하세요.
/*
 * create table question
 * (
 *     id         bigint auto_increment
 *         primary key,
 *     title      varchar(100) not null,
 *     content    text         not null,
 *     created_at datetime     not null
 * );
 */

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, updatable = false, name = "created_at")
    private ZonedDateTime createdAt;



}
