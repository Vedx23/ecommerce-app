package com.ecom.clothingapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.clothingapp.models.User;

import jakarta.transaction.Transactional;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByEmail(String email);
}
