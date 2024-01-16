package dev.marcus.anotaAiApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.marcus.anotaAiApi.domain.category.Category;

public interface CategoryRepository extends MongoRepository<Category, String> { }
