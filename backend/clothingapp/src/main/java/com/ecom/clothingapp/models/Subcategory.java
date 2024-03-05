package com.ecom.clothingapp.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "sub_category")
@AttributeOverride(name = "id", column = @Column(name = "sub_category_id"))
public class Subcategory extends Base{

    
    private Subcat subCategory;

    //many to one unidirectional
    private Category category;
    
}
