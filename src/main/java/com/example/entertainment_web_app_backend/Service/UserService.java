package com.example.entertainment_web_app_backend.Service;

import com.example.entertainment_web_app_backend.Model.Movie;
import com.example.entertainment_web_app_backend.Model.Users;
import com.example.entertainment_web_app_backend.Repository.MovieRepo;
import com.example.entertainment_web_app_backend.Repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final MovieRepo movieRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public UserService(UserRepo userRepo , AuthenticationManager authenticationManager, JWTService jwtService, MovieRepo movieRepo) {
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.movieRepo = movieRepo;
    }

    public String register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        this.userRepo.save(user);
        return "User added successfully";
    }

    public String verify(Users user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            return this.jwtService.generateToken(user.getUsername());

        } catch (AuthenticationException e) {
            return "username or password are invalid";
        }
    }

    public Users getMyProfile(String username) {
        return this.userRepo.findByUsername(username);
    }

    public String addMovieToUser(int userId, int movieId){
        Optional<Users> user = this.userRepo.findById(userId);
        Optional<Movie> movie = this.movieRepo.findById(movieId);

        if(user.isPresent() && movie.isPresent()){
            Users userEntity = user.get();
            Movie movieEntity = movie.get();
            userEntity.getMovies().add(movieEntity);
            this.userRepo.save(userEntity);
            return "movie added to user set successfully";
        }
        return "something goes wrong";
    }

    public Set<Movie> getAllMyMovies(int userId) {
        Optional<Users> user = this.userRepo.findById(userId);
        if(user.isPresent()){
            Users userEntity = user.get();
            return userEntity.getMovies();
        }
        return new HashSet<>();
    }

    public String removeMovieFromMoviesList(int userId, int movieId) {
        Optional<Users> user = this.userRepo.findById(userId);
        Optional<Movie> movie = this.movieRepo.findById(movieId);

        if(user.isPresent() && movie.isPresent()){
            Users userEntity = user.get();
            Movie movieEntity = movie.get();
            userEntity.getMovies().remove(movieEntity);
            this.userRepo.save(userEntity);
            return "movie removed successfully from user set";
        }
        return "something goes wrong";
    }
}
