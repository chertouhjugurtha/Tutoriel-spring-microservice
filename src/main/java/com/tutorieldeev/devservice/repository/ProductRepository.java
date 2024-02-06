package com.tutorieldeev.devservice.repository;

import com.tutorieldeev.devservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
