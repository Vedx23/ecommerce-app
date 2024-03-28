package com.ecom.clothingapp.dto;

import com.ecom.clothingapp.models.Role;

public record AuthRequestDto(String firstName, String lastName, String email, String password, String phonenumber, Role role) {
    
}
