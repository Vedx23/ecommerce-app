package com.ecom.clothingapp.service;

import java.util.Optional;

import com.ecom.clothingapp.dto.SignupRequestDto;

public interface AuthService{

    Optional<String> signin(String email, String password);
    Optional<String> signup(SignupRequestDto signupRequestDto);
}
