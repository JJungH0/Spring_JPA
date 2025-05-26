package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

// TODO #2: `OrderItem` Entity 클래스의 복합키 클래스인 `OrderItemPk` 클래스를 작성하세요.
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Embeddable
public class OrderItemPk implements Serializable {
//    public OrderItemPk(long orderId, int lineNumber) {
//        this.orderId = orderId;
//        this.lineNumber = lineNumber;
//    }

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "line_number")
    private int lineNumber;


}
