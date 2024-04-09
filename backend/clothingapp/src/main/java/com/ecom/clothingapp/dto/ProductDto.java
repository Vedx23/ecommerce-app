package com.ecom.clothingapp.dto;

import com.ecom.clothingapp.models.Category;
import com.ecom.clothingapp.models.Color;
import com.ecom.clothingapp.models.Size;
import com.ecom.clothingapp.models.Subcategory;

public record ProductDto(String productName, String productDescription, Size size, Category category, Subcategory subcategory, Long stock, Color color, Double price) {
}
