package com.example.entertainment_web_app_backend.Service;

import com.example.entertainment_web_app_backend.Model.Movie;
import com.example.entertainment_web_app_backend.Repository.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public String addMovie(Movie movie) {
        Optional<Movie> movieAlreadyExist = this.movieRepo.findByTitle(movie.getTitle());
        if(movieAlreadyExist.isPresent()){
            return "Movie already exist";
        }else{
            this.movieRepo.save(movie);
            return "Movie added successfully";
        }
    }

    public List<Movie> getAllMovies() {
        return this.movieRepo.findAll();
    }

    public String updateMovie(int id ,Movie movie) {
        Optional<Movie> movieAlreadyExist = this.movieRepo.findById(id);
        if(!movieAlreadyExist.isPresent()){
            return "Movie doesn't exist";
        }else{
            Movie updatedMovie = movieAlreadyExist.get();
            updatedMovie.setTitle(movie.getTitle());
            updatedMovie.setCategory(movie.getCategory());
            updatedMovie.setBookmarked(movie.getBookmarked());
            updatedMovie.setRating(movie.getRating());
            updatedMovie.setThumbnail_regular_large(movie.getThumbnail_regular_large());
            updatedMovie.setThumbnail_trending_large(movie.getThumbnail_trending_large());
            updatedMovie.setTrending(movie.getTrending());
            updatedMovie.setYear(movie.getYear());
            this.movieRepo.save(updatedMovie);
            return "Movie updated successfully";
        }

    }
}
