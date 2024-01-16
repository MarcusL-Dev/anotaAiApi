package dev.marcus.anotaAiApi.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.anotaAiApi.domain.category.Category;
import dev.marcus.anotaAiApi.domain.product.Product;
import dev.marcus.anotaAiApi.domain.product.ProductDTO;
import dev.marcus.anotaAiApi.domain.product.exceptions.ProductNotFoundException;
import dev.marcus.anotaAiApi.repositories.ProductRepository;
import dev.marcus.anotaAiApi.services.interfaces.CategoryService;
import dev.marcus.anotaAiApi.services.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String productId) {
        Product product = productRepository.findById(productId)
            .orElseThrow(ProductNotFoundException::new);

        return product;
    }

    @Override
    public Product insertProduct(ProductDTO productData) {
        Product newProduct = new Product(productData);
        Category category = categoryService.getCategory(productData.categoryId());
         
        newProduct.setCategory(category);
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(ProductDTO productData, String productId) {
        
        Product product = getProduct(productId);

        if (!productData.title().isEmpty()) product.setTitle(productData.title());
        if (!productData.description().isEmpty()) product.setDescription(productData.description());
        if (!(productData.price() == null)) product.setPrice(productData.price());

        if (!productData.categoryId().isEmpty()) {
            Category category = categoryService.getCategory(productData.categoryId());
            product.setCategory(category);
        }

        return productRepository.save(product); 
    }

    @Override
    public Product deleteProduct(String productId) {
        Product product = getProduct(productId);
            
        productRepository.delete(product); 
        return product;
    }
    
}
