package com.twinleaves.assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twinleaves.assignment.controller.common.BaseController;
import com.twinleaves.assignment.dto.request.ProductRequestDTO;
import com.twinleaves.assignment.dto.response.SuccessResponse;
import com.twinleaves.assignment.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController extends BaseController<Object>{

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<SuccessResponse<Object>> createProduct(@Valid @RequestBody ProductRequestDTO productDetails) {
        return success(productService.saveProduct(productDetails), "OK", HttpStatus.OK);
    }
    
    @GetMapping("/products/list")
    public ResponseEntity<SuccessResponse<Object>> getListOfProducts(){
    	return success(productService.getAllProducts(), "OK", HttpStatus.OK);
    }
}
