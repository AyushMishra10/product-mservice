package com.prj.ms.product.controller;

import com.prj.ms.product.dto.ProductRequest;
import com.prj.ms.product.model.Product;
import com.prj.ms.product.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest){
        //used dto classes here for decoupling
    	return productService.createProduct(productRequest);
    	
    }
}
