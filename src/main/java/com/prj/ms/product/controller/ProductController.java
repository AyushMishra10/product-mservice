package com.prj.ms.product.controller;

import com.prj.ms.product.dto.ProductRequest;
import com.prj.ms.product.dto.ProductResponse;
import com.prj.ms.product.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        //used dto classes here for decoupling
    	return productService.createProduct(productRequest);
    	
    }

    @GetMapping("/getProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
