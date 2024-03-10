package com.ecom.clothingapp.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "product")
@AttributeOverride(name = "id", column = @Column(name = "product_id"))
public class Product extends Base {
    
    private String productName;

    private String productDescription;

    private Size size;

    @OneToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "sub_category_id")
    private Subcategory category;

    private long stock;

    private Color color;

    private Double price;
    
}
