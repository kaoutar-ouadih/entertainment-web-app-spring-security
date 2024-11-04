package com.example.entertainment_web_app_backend.Controller;

import com.example.entertainment_web_app_backend.Model.Category;
import com.example.entertainment_web_app_backend.Service.CategoryService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public String addCategory(@RequestBody Category category){
        return this.categoryService.addCategory(category);
    }
}
