package com.prj.ms.product.service;

import com.prj.ms.product.dto.ProductRequest;
import com.prj.ms.product.dto.ProductResponse;
import com.prj.ms.product.model.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.prj.ms.product.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    
    public ProductResponse createProduct(ProductRequest productRequest){
    	Product product = Product.builder()
    			.name(productRequest.name())
    			.description(productRequest.description())
    			.price(productRequest.price())
    			.build();
    		productRepository.save(product);
    		log.info("Product Created Successfully");
    		return new ProductResponse(product.getId(), product.getName(),
					product.getDescription(),product.getPrice());
    }

	public List<ProductResponse> getAllProducts(){
		return productRepository.findAll()
				.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(),
					product.getDescription(),product.getPrice()))
				.toList();
	}
}
