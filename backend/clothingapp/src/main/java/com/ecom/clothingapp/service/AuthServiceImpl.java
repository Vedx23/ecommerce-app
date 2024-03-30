package com.ecom.clothingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.clothingapp.dto.SignupRequestDto;
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
        System.out.println("SIGN IN SERVICE CALLED");

        Optional<User> user = userRepository.findByEmail(email);

        return user.map(u -> {
            UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(u.getEmail(), u.getPassword());
            Authentication authenticate1 = authManager.authenticate(token1);
            String username1 = ((UserDetails)authenticate1.getPrincipal()).getUsername();
            return Optional.of(JWTutils.generateToken(username1));
        }).orElseGet(Optional::empty);

    }

    @Override
    public Optional<String> signup(SignupRequestDto siginUpRequestDto) {

        //construct the user first here
        System.out.println("SIGN UP SERVICE CALLED");
        User user = User.builder()
        .firstName(siginUpRequestDto.firstName())
        .lastName(siginUpRequestDto.lastName())
        .email(siginUpRequestDto.email())
        .password(passwordEncoder.encode(siginUpRequestDto.password()))
        .phoneNumber(siginUpRequestDto.phonenumber())
        .role(siginUpRequestDto.role()).build();

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
