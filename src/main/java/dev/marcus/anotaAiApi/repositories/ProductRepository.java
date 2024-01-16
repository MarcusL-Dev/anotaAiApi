package dev.marcus.anotaAiApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.marcus.anotaAiApi.domain.product.Product;

public interface ProductRepository extends MongoRepository<Product, String> { }
