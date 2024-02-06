package com.tutorieldeev.devservice.service;


import com.tutorieldeev.devservice.dto.ProductRequest;
import com.tutorieldeev.devservice.dto.ProductResponse;
import com.tutorieldeev.devservice.model.Product;
import com.tutorieldeev.devservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
   private final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest) {
       Product product = Product.builder()
               .name(productRequest.getName())
               .description(productRequest.getDescription())
               .price(productRequest.getPrice())
               .build();

       productRepository.save(product);
       log.info("Product {} is saved", product.getId());
    }
     public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }
    
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
