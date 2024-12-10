package com.twinleaves.assignment.service.impl;

import com.twinleaves.assignment.dto.request.ProductRequestDTO;
import com.twinleaves.assignment.entities.Product;
import com.twinleaves.assignment.repository.ProductRepository;
import com.twinleaves.assignment.service.ProductService;
import com.twinleaves.assignment.utils.DateUtility;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepo;

	@Override
	public Product saveProduct(ProductRequestDTO productDetails) {
		Product product = Product.builder().productName(productDetails.getProductName())
				.createdOn(DateUtility.getCurrentUTCDate()).build();
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll() ;
	}
}
