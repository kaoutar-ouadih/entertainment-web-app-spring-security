package com.example.entertainment_web_app_backend.Controller;

import com.example.entertainment_web_app_backend.Model.Movie;
import com.example.entertainment_web_app_backend.Model.Users;
import com.example.entertainment_web_app_backend.Service.UserService;
import jakarta.persistence.SecondaryTable;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = {"https://entertainment-web-app-frontend-s.onrender.com"})
@RequestMapping("/users")
public class Usercontroller {
    private final UserService userService;

    public Usercontroller(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user){
        return this.userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }

    @GetMapping("/getMyProfile")
    public Users getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return this.userService.getMyProfile(username);
    }

    @PostMapping("/{userId}/movies/{movieId}")
    public String addMovieToUser(@PathVariable int userId, @PathVariable int movieId){
        return this.userService.addMovieToUser(userId, movieId);
    }

    @GetMapping("/{userId}/movies")
    public Set<Movie> getAllMyMovies(@PathVariable int userId){
        return this.userService.getAllMyMovies(userId);
    }

    @PostMapping("/remove/{userId}/movies/{movieId}")
    public String removeMovieFromMoviesList(@PathVariable int userId, @PathVariable int movieId){
        return this.userService.removeMovieFromMoviesList(userId, movieId);
    }
}
