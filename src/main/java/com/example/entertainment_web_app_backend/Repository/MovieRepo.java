package com.example.entertainment_web_app_backend.Repository;

import com.example.entertainment_web_app_backend.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{
    Optional<Movie> findByTitle(String title);
}
