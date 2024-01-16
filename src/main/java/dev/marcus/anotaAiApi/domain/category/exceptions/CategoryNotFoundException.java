package dev.marcus.anotaAiApi.domain.category.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
    
}
