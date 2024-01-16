package dev.marcus.anotaAiApi.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.marcus.anotaAiApi.domain.category.Category;
import dev.marcus.anotaAiApi.domain.category.CategoryDTO;
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
    public Optional<Category> getCategory(String categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category insertCategory(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @Override
    public Category udateCategory(CategoryDTO categoryData, String categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        Category updatedCategory = category.get();

        updatedCategory.setTitle(categoryData.title());
        updatedCategory.setDescription(categoryData.description());
        updatedCategory.setOwnerId(categoryData.ownerId());

        categoryRepository.save(updatedCategory);
        return updatedCategory;
    }

    @Override
    public Category deleteCategory(String categoryId) {
        Category deletedCategory = categoryRepository.findById(categoryId).get();
        categoryRepository.delete(deletedCategory);
        return deletedCategory;
    }
}
