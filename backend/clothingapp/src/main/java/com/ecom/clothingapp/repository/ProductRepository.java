package com.ecom.clothingapp.repository;

import com.ecom.clothingapp.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
