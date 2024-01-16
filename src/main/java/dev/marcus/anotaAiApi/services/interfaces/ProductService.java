package dev.marcus.anotaAiApi.services.interfaces;

import java.util.List;
import java.util.Optional;

import dev.marcus.anotaAiApi.domain.product.Product;
import dev.marcus.anotaAiApi.domain.product.ProductDTO;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(String prodctId);
    Product insertProduct(ProductDTO productData);
    Product updateProduct(ProductDTO productData, String productId);
    Product deleteProduct(String productId);
}
