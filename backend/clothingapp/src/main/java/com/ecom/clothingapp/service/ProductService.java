package com.ecom.clothingapp.service;

import com.ecom.clothingapp.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public Page<Product> getProductsByPage(Pageable pageable);

}
