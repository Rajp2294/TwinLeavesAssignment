package com.twinleaves.assignment.service;

import java.util.List;

import com.twinleaves.assignment.dto.request.ProductRequestDTO;
import com.twinleaves.assignment.entities.Product;

public interface ProductService {
    public Product saveProduct(ProductRequestDTO productDetails);
    
    public List<Product> getAllProducts();
}
