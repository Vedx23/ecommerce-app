package com.ecom.clothingapp.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDetailsRepository extends JpaRepository<CustomUserDetails, Long>{
    
    Optional<CustomUserDetails> findByEmail(String email);
}
