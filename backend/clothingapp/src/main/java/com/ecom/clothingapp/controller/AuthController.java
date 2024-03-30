package com.ecom.clothingapp.controller;

import java.util.Optional;

import com.ecom.clothingapp.dto.SigninRequestDto;
import com.ecom.clothingapp.service.AuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.clothingapp.dto.SignupRequestDto;
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
    public ResponseEntity<AuthResponseDto> signin(@RequestBody SigninRequestDto signinRequestDto) {
        System.out.println("SIGN IN CONTROLLER CALLED");
        Optional<String> jwtToken = authService.signin(signinRequestDto.email(), signinRequestDto.password());
        return jwtToken.map(token -> ResponseEntity.status(HttpStatus.OK)
                        .body(new AuthResponseDto(token, AuthStatus.SIGNIN_SUCCESS)))
                .orElseGet(()->ResponseEntity.status(HttpStatus.OK)
                        .body(new AuthResponseDto(null, AuthStatus.SIGNIN_FAILURE)));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody SignupRequestDto signUpRequestDto) {
        System.out.println("SIGN UP CONTROLLER CALLED");
        Optional<String> jwtToken = authService.signup(signUpRequestDto);
        return jwtToken.map(s -> ResponseEntity.status(HttpStatus.OK)
                        .body(new AuthResponseDto(s, AuthStatus.SIGNUP_SUCCESS)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new AuthResponseDto(null, AuthStatus.SIGNUP_FAILURE)));

    }
    
}
