package com.ecom.clothingapp.models;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name = "wishlist")
@AttributeOverride(name = "id", column = @Column(name = "wish_list_id"))
public class WishList extends Base{

    @OneToMany(mappedBy = "wishlist", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<WishListItem> wishListItems;
    
}
