package com.example.entertainment_web_app_backend.Controller;

import com.example.entertainment_web_app_backend.Model.Movie;
import com.example.entertainment_web_app_backend.Service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping("/add")
    public String addMovie(@RequestBody Movie movie){
        return this.movieService.addMovie(movie);
    }

//    @CrossOrigin(origins = "*", allowedHeaders = "Authorization")
    @RequestMapping("/all")
    public List<Movie> getAllMovies(){
        return this.movieService.getAllMovies();
    }

    @PutMapping("/update/{id}")
    public String updateMovie(@PathVariable int id ,@RequestBody Movie movie){
        return this.movieService.updateMovie(id, movie);
    }
}
