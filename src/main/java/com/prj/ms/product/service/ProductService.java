package com.prj.ms.product.service;

import com.prj.ms.product.dto.ProductRequest;
import com.prj.ms.product.model.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.prj.ms.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    
    public Product createProduct(ProductRequest productRequest){
    	Product product = Product.builder()
    			.name(productRequest.name())
    			.description(productRequest.description())
    			.price(productRequest.price())
    			.build();
    		productRepository.save(product);
    		log.info("Product Created Successfully");
    		return product;
    }
}
