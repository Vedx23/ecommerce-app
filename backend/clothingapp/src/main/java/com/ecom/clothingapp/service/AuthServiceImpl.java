package com.ecom.clothingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.clothingapp.dto.AuthRequestDto;
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
        /*
        find if user exists by email
        1. user exists
            match the passwords if passwords do not match say that password is incorrect
        2. user does not exist
            say that username not found sign up instead !
        */

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticate = authManager.authenticate(token);
        String username = ((UserDetails)authenticate.getPrincipal()).getUsername();
        return Optional.of(JWTutils.generateToken(username));

    }

    @Override
    public Optional<String> signup(AuthRequestDto authRequestDto) {

        //construct the user first here

        User user = User.builder()
        .firstName(authRequestDto.firstName())
        .lastName(authRequestDto.lastName())
        .email(authRequestDto.email())
        .password(passwordEncoder.encode(authRequestDto.password()))
        .phoneNumber(authRequestDto.phonenumber())
        .role(authRequestDto.role()).build();

        if(userRepository.existsByEmail(user.getEmail())){
            log.info("User "+user.getEmail()+"tried creating already existing account");
            return Optional.empty();
        }

        try {
            User createdUser = userRepository.save(user);
            return Optional.of(JWTutils.generateToken(createdUser.getEmail()));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage()+"\n error creating a new user for user"+user);
        }

        return Optional.empty();

    }

}
