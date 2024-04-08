package com.ecom.clothingapp.service;

import com.ecom.clothingapp.models.Product;
import com.ecom.clothingapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public Page<Product> getProductsByPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
