package com.example.entertainment_web_app_backend.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_movie",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns =@JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies = new HashSet<>();

    public Users(){
    }

    public Users(int id ,String username, String password, Set<Movie> movies) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.movies = movies;
    }

    public Users(int id, String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
