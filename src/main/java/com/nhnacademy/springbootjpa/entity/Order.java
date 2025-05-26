package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Order {
    @Id
    private long id;

    @Column(name = "order_At")
    private Date orderDate;
}
