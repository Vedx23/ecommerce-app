package com.ecom.clothingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.emitter.Emitable;

import com.ecom.clothingapp.models.User;
import com.ecom.clothingapp.repository.UserRepository;
import com.ecom.clothingapp.utils.JWTutils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final AuthenticationManager authManager;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepository userRepository;

    @Override
    public Optional<String> signin(String email, String password) {

        return null;
    }

    @Override
    public Optional<String> signup(User user) {

        if(userRepository.existsByEmail(user.getEmail())){
            log.info("User "+user.getEmail()+"tried creating already existing account");
            throw new RuntimeException("User already Exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        
        return Optional.empty();

    }

}
