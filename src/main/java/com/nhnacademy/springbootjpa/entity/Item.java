package com.nhnacademy.springbootjpa.entity;

// TODO #1: `item` 테이블과 매핑될 `Item` Entity 클래스를 작성하세요.
/*
 * create table item
 * (
 *     id    bigint auto_increment
 *         primary key,
 *     name  varchar(40) not null,
 *     price bigint      not null
 * );
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {

    @Id
    // DB에서 값을 자동으로 증가시켜줄 것을 명령
    // MySQL (= AUTO_INCREMENT)
    // H2 (= IDENTITY)와 같음
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

}
