package com.ecom.clothingapp.service;

import java.util.Optional;

import com.ecom.clothingapp.models.User;

public interface AuthService{

    Optional<String> signin(String email, String password);
    Optional<String> signup(User user);    
}
