package com.example.entertainment_web_app_backend.Repository;


import com.example.entertainment_web_app_backend.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{
    Optional<Category> findCategoryByName(String name);
}
