package dev.marcus.anotaAiApi.domain.category;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryDTO categoryData){
        this.id = UUID.randomUUID().toString();
        this.title = categoryData.title();
        this.description = categoryData.description();
        this.ownerId = categoryData.ownerId();
    }
}
