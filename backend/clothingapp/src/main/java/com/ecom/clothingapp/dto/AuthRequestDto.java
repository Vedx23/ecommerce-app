package com.ecom.clothingapp.dto;

import com.ecom.clothingapp.models.Authority;

public record AuthRequestDto(String firstName, String lastName, String email, String password, String phonenumber, Authority authority) {
    
}
