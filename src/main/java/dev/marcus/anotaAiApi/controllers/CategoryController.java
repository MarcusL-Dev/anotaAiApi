package dev.marcus.anotaAiApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.anotaAiApi.domain.category.Category;
import dev.marcus.anotaAiApi.domain.category.CategoryDTO;
import dev.marcus.anotaAiApi.services.interfaces.CategoryService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable("id") String categoryId){
        return ResponseEntity.ok().body(categoryService.getCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<Category> insertCategory(@RequestBody CategoryDTO categoryData){
        return ResponseEntity.ok().body(categoryService.insertCategory(categoryData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryDTO categoryData, @PathVariable("id") String categoryId){
        return ResponseEntity.ok().body(categoryService.udateCategory(categoryData, categoryId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") String categoryId){
        return ResponseEntity.ok().body(categoryService.deleteCategory(categoryId));
    }
}
