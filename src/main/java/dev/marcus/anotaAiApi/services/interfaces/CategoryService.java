package dev.marcus.anotaAiApi.services.interfaces;

import java.util.List;
import java.util.Optional;
import dev.marcus.anotaAiApi.domain.category.Category;
import dev.marcus.anotaAiApi.domain.category.CategoryDTO;

public interface CategoryService {

    List<Category> getAllCategories();
    Optional<Category> getCategory(String categoryId);
    Category insertCategory(CategoryDTO categoryData);
    Category udateCategory(CategoryDTO categoryDTO, String categoryId);
    Category deleteCategory(String categoryId);
}
