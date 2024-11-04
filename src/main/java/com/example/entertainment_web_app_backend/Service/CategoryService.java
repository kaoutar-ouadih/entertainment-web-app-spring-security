package com.example.entertainment_web_app_backend.Service;

import com.example.entertainment_web_app_backend.Model.Category;
import com.example.entertainment_web_app_backend.Repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public String addCategory(Category category) {
        Optional<Category> catego = this.categoryRepo.findCategoryByName(category.getName());
        if(catego.isPresent()){
            return "Category already exists";
        }else{
            this.categoryRepo.save(category);
            return "Category added successfully";
        }
    }
}
