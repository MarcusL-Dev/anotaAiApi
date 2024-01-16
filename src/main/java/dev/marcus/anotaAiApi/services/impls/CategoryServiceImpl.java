package dev.marcus.anotaAiApi.services.impls;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.marcus.anotaAiApi.domain.category.Category;
import dev.marcus.anotaAiApi.domain.category.CategoryDTO;
import dev.marcus.anotaAiApi.domain.category.exceptions.CategoryNotFoundException;
import dev.marcus.anotaAiApi.repositories.CategoryRepository;
import dev.marcus.anotaAiApi.services.interfaces.CategoryService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(String categoryId) {
        try {
            return categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + categoryId));
        } catch (CategoryNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while retrieving the category", e);
        }
    }

    @Override
    public Category insertCategory(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @Override
    public Category udateCategory(CategoryDTO categoryData, String categoryId) {
        Category category = getCategory(categoryId);

        category.setTitle(categoryData.title());
        category.setDescription(categoryData.description());
        category.setOwnerId(categoryData.ownerId());

        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(String categoryId) {
        Category category = getCategory(categoryId);
        categoryRepository.delete(category);
        return category;
    }
}
