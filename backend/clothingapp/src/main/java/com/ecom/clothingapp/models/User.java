package com.ecom.clothingapp.models;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends Base{

    @Column(length = 50, nullable = false)
    private String firstName;
    
    @Column(length = 50, nullable = false)
    private String lastName;
    
    @Column(length = 100, nullable = false)
    private String email;
    
    @Column(length = 500, nullable = false)
    private String password;
    
    @Column(length = 10, nullable = false)
    private String phoneNumber;
    
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Lob
    @Column(nullable = true)
    private String profilePicture;

    @Column(nullable = true)
    private List<Address> addressList;
    
    @Column(nullable = true)
    private Cart cart;
    
    @Column(nullable = true)
    private wishList wishlist;
    
    @Column(nullable = true)
    private List<Orders> orderList;
    
}
