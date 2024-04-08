package com.ecom.clothingapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/protected/")
public class ProtectedResource {

    @GetMapping("/")
    public ResponseEntity<String> getProtectedResource() {
        System.out.println("PROTECTED RESOURCE CALLED");
        return ResponseEntity.status(HttpStatus.OK).body("secret message received :)");
    }

}