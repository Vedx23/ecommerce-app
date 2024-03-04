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
    public String firstName;
    @Column(length = 50, nullable = false)
    public String lastName;
    @Column(length = 100, nullable = false)
    public String email;
    @Column(length = 65535, nullable = false)
    public String password;
    @Column(length = 10, nullable = false)
    public String phoneNumber;
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    public Role role;
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    public AccountStatus status;
    @Lob
    @Column(nullable = true)
    public String profilePicture;
    @Column(nullable = true)
    public List<Address> addressList;
    @Column(nullable = true)
    public Cart cart;
    @Column(nullable = true)
    public wishList wishlist;
    @Column(nullable = true)
    public List<Orders> orderList;

    
}
