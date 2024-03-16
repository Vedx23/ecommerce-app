package com.ecom.clothingapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/v1/products")
public class Products {

    @GetMapping
    public ResponseEntity<String> getAllProducts(){
        return ResponseEntity.ok().body("apple, mango, pants, shorts, tshirt");
    }
    
    
}
