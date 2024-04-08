package com.ecom.clothingapp.controller;

import com.ecom.clothingapp.models.Product;
import com.ecom.clothingapp.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductsController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/test")
    public String getproducts(){
        return "these are the products";
    }

    @GetMapping("/allproducts")
    public ResponseEntity<String> getProductsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortby,
            @RequestParam(defaultValue = "asc") String orderby ){
        Sort.Direction direction = Sort.Direction.ASC;
        try {
             direction = Sort.Direction.valueOf(orderby.toUpperCase());
        }catch (IllegalArgumentException e){
            log.info(e.getMessage());
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortby));
        Page<Product> pageOfProducts = productService.getProductsByPage(pageable);
        ObjectMapper mapper = new ObjectMapper();
        String prodJson;
        try {
            prodJson = mapper.writeValueAsString(pageOfProducts.getContent());
        }catch (JsonProcessingException e){
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("its not you, its us");
        }
        return ResponseEntity.status(HttpStatus.OK).body(prodJson);
    }
}
