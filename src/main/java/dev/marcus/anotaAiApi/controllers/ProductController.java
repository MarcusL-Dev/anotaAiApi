package dev.marcus.anotaAiApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.anotaAiApi.domain.product.Product;
import dev.marcus.anotaAiApi.domain.product.ProductDTO;
import dev.marcus.anotaAiApi.services.interfaces.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String productId){
        return ResponseEntity.ok().body(productService.getProduct(productId).get());
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody ProductDTO productData){
        return ResponseEntity.ok().body(productService.insertProduct(productData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO productData, @PathVariable("id") String productId){
        return ResponseEntity.ok().body(productService.updateProduct(productData, productId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String productId){
        return ResponseEntity.ok().body(productService.deleteProduct(productId));
    }
}
