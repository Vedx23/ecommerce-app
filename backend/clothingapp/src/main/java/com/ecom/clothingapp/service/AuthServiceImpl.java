package com.ecom.clothingapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.clothingapp.dto.AuthRequestDto;
import com.ecom.clothingapp.models.Role;
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
    @Autowired
    private final JWTutils jwtUtils;

    @Override
    public Optional<String> signin(String email, String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticate = authManager.authenticate(token);
        String username = ((UserDetails)authenticate.getPrincipal()).getUsername();
        return Optional.of(jwtUtils.generateToken(username));

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
        .roles(List.of(new Role(authRequestDto.authority()))).build();

        if(userRepository.existsByEmail(user.getEmail())){
            log.info("User "+user.getEmail()+"tried creating already existing account");
            return Optional.empty();
        }

        try {
            User createdUser = userRepository.save(user);
            return Optional.of(jwtUtils.generateToken(createdUser.getEmail()));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage()+"\nerror creating a new user for user"+user.toString());
        }

        return Optional.empty();

    }

}
