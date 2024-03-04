package com.ecom.clothingapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    
    @GetMapping("/hw")
    public String helloWorld(){
        return "<h1 color=red>Hello World</h1>"; 
    }

}
