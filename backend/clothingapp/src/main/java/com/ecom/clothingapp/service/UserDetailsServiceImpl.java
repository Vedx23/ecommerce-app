package com.ecom.clothingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ecom.clothingapp.models.User;
import com.ecom.clothingapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
//custom user details service
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("USER DETAILS SERVICE CALLED");
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                List.of(user.getRole()));

    }

}
