package com.ecom.clothingapp.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@AttributeOverride(name = "id", column = @Column(name = "category_id"))
public class Category extends Base{
    
    @Enumerated(EnumType.STRING)
    private CategoryName category;

}
