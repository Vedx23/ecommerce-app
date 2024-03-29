package com.ecom.clothingapp.service;

import java.util.Optional;

import com.ecom.clothingapp.dto.AuthRequestDto;

public interface AuthService{

    Optional<String> signin(String email, String password);
    Optional<String> signup(AuthRequestDto authRequestDto);    
}
