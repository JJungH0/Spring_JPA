package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// TODO #2: `OrderItem` Entity 클래스의 복합키 클래스인 `OrderItemPk` 클래스를 작성하세요.
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Embeddable
public class OrderItemPk {
//    public OrderItemPk(long orderId, int lineNumber) {
//        this.orderId = orderId;
//        this.lineNumber = lineNumber;
//    }

    private Long orderId;

    private int lineNumber;


}
