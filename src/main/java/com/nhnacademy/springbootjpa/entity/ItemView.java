package com.nhnacademy.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

// TODO #2: ItemView 프로젝션 인터페이스 - test case를 통과할 수 있도록 ItemView를 작성하세요.
public interface ItemView {

    String getName(); // Item의 name

    List<OrderItemView> getOrderItems(); // Item -> List<OrderItem>

    interface OrderItemView { // OrderItem의 정보를 담는 중첩 인터페이스
        Integer getQuantity(); // OrderItem의 quantity 필드

        OrderView getOrder(); // OrderItem -> Order
    }

    interface OrderView { // Order의 정보를 담는 중첩 인터페이스
        @JsonFormat(pattern = "yyyy-MM-dd")
        ZonedDateTime getOrderedAt(); // Order의 orderedAt 필드
    }
}
