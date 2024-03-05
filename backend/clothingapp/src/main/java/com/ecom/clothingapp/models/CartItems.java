package com.ecom.clothingapp.models;

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
@Table(name = "cart_items")
public class CartItems extends Base{

    //many to one
    private Cart cart;
    //one to one
    private Product product;
    //just an integer to calculate quantity
    private Long quantity;

}
