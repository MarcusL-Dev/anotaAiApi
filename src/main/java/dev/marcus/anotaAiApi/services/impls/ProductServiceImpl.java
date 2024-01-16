package dev.marcus.anotaAiApi.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.anotaAiApi.domain.category.Category;
import dev.marcus.anotaAiApi.domain.product.Product;
import dev.marcus.anotaAiApi.domain.product.ProductDTO;
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
    public Optional<Product> getProduct(String prodctId) {
        return productRepository.findById(prodctId);
    }

    @Override
    public Product insertProduct(ProductDTO productData) {
        Product newProduct = new Product(productData);

        Category productCategory = categoryService.getCategory(productData.categoryId()).get();
        newProduct.setCategory(productCategory);
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(ProductDTO productData, String productId) {
        Optional<Product> product = productRepository.findById(productId);
        Product updatedProduct = product.get();
        updatedProduct.setTitle(productData.title());
        updatedProduct.setDescription(productData.description());
        updatedProduct.setPrice(productData.price());
        productRepository.save(updatedProduct);
        return updatedProduct;
    }

    @Override
    public Product deleteProduct(String productId) {
        Optional<Product> product = productRepository.findById(productId);
        Product deletedProduct = product.get();
        productRepository.delete(deletedProduct); 
        return deletedProduct;
    }
    
}
