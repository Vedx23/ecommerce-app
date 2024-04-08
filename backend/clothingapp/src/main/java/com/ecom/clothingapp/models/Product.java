package com.ecom.clothingapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "sub_category_id", referencedColumnName = "sub_category_id")
    private Subcategory subcategory;

    private long stock;

    @Enumerated(EnumType.STRING)
    private Color color;

    private Double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Images> images = new ArrayList<>();
    
}
