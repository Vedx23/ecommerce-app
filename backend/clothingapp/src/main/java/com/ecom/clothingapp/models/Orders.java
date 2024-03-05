package com.ecom.clothingapp.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "orders")
@AttributeOverride(name = "id", column = @Column(name = "order_id"))
public class Orders extends Base{

    //manytoone
    private User user;

    private Double orderTotal;

    private LocalDate date;

    //enum
    private OrderStatus status;

    //mapped to payment id
    //one order will have only one payment
    private Payment payment;

    private List<Orderitems> orderItems;


}
