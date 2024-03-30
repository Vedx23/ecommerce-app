package com.ecom.clothingapp.controller;

import java.util.Optional;

import com.ecom.clothingapp.service.AuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.clothingapp.dto.AuthRequestDto;
import com.ecom.clothingapp.dto.AuthResponseDto;
import com.ecom.clothingapp.dto.AuthStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    @Autowired
    public AuthServiceImpl authService;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponseDto> signin(@RequestBody AuthRequestDto authRequestDto) {
        Optional<String> jwtToken = authService.signin(authRequestDto.email(), authRequestDto.password());
        String token = jwtToken.orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(new AuthResponseDto(token,AuthStatus.SIGNIN_SUCCESS));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody AuthRequestDto authRequestDto) {

        Optional<String> jwtToken = authService.signup(authRequestDto);
        return jwtToken.map(s -> ResponseEntity.status(HttpStatus.OK).body(new AuthResponseDto(s, AuthStatus.SIGNUP_SUCCESS))).orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).body(new AuthResponseDto(null, AuthStatus.SIGNUP_FAILURE)));

    }
    
}
