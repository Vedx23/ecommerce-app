package com.ecom.clothingapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.clothingapp.dto.AuthRequestDto;
import com.ecom.clothingapp.dto.AuthResponseDto;
import com.ecom.clothingapp.dto.AuthStatus;
import com.ecom.clothingapp.models.User;
import com.ecom.clothingapp.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    public final AuthService authService;
    

    @PostMapping("/signin")
    public ResponseEntity<AuthResponseDto> signin(@RequestBody AuthRequestDto authRequestDto) {
        Optional<String> jwtToken = authService.signin(authRequestDto.email(), authRequestDto.password());
        String token = jwtToken.orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(new AuthResponseDto(token,AuthStatus.SIGNIN_SUCCESS));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> singup(@RequestBody AuthRequestDto authRequestDto) {
        User newUser = new User();
        newUser.setFirstName(authRequestDto.firstName());
        newUser.setLastName(authRequestDto.lastName());
        newUser.setEmail(authRequestDto.email());
        newUser.setPassword(authRequestDto.password());
        newUser.setRole(authRequestDto.role());
        
        Optional<String> jwtToken = authService.signup(newUser);
        String token = jwtToken.orElseThrow();

        return null;

    }
    
}
