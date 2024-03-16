package com.ecom.clothingapp.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.clothingapp.config.JwtService;
import com.ecom.clothingapp.models.User;
import com.ecom.clothingapp.repository.UserRepository;
import com.ecom.clothingapp.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authManager;

    public AuthenticationResponse signUp(SignUpRequest request) {

        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(request.getRole());
        newUser.setStatus(request.getAccountStaus());

        userRepository.save(newUser);
        CustomUserDetails u = new CustomUserDetails(newUser);
        var token = jwtService.generateToken(u);

        return AuthenticationResponse.builder().accessToken(token).build();
    }

    public AuthenticationResponse signIn(SignInRequest request) {

    authManager.authenticate(
    new UsernamePasswordAuthenticationToken(
    request.getEmail(),
    request.getPassword()));
    
    User existingUser = userRepository.findByEmail(request.getEmail()).orElseThrow();
    var token = jwtService.generateToken(new CustomUserDetails(existingUser));

    return AuthenticationResponse.builder().accessToken(token).build();

}

}
