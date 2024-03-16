package com.ecom.clothingapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.clothingapp.security.CustomUserDetails;



public interface UserRepository extends JpaRepository<CustomUserDetails, Long>{
    
    Optional<CustomUserDetails> findByEmail(String email);
}
