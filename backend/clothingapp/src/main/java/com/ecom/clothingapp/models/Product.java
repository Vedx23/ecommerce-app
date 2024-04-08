package com.ecom.clothingapp.models;

import jakarta.persistence.*;
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
@Table(name = "product")
@AttributeOverride(name = "id", column = @Column(name = "product_id"))
public class Product extends Base {
    
    private String productName;

    @Column(columnDefinition = "tinytext")
    private String productDescription;

    @Enumerated(EnumType.STRING)
    private Size size;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "sub_category_id")
    private Subcategory subcategory;

    private long stock;

    @Enumerated(EnumType.STRING)
    private Color color;

    private Double price;
    
}
