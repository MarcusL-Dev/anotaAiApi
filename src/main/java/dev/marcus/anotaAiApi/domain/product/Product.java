package dev.marcus.anotaAiApi.domain.product;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import dev.marcus.anotaAiApi.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;

    public Product(ProductDTO productData) {
        this.id = UUID.randomUUID().toString();
        this.title = productData.title();
        this.description = productData.description();
        this.ownerId = productData.ownerId();
        this.price = productData.price();
    }    
}
