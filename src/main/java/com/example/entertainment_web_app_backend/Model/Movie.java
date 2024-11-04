package com.example.entertainment_web_app_backend.Model;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    private String title;
    private  String thumbnail_trending_large;
    private String thumbnail_regular_large;
    private int year;
    private String rating;
    private boolean bookmarked;
    private boolean trending;

    @ManyToOne
    private Category category;

    public Movie(){
    }
    public Movie(String title, String thumbnail_trending_large, String thumbnail_regular_large, int year, String rating, boolean bookmarked, boolean trending, Category category) {
        this.title = title;
        this.thumbnail_trending_large = thumbnail_trending_large;
        this.thumbnail_regular_large = thumbnail_regular_large;
        this.year = year;
        this.rating = rating;
        this.bookmarked = bookmarked;
        this.trending = trending;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail_trending_large() {
        return thumbnail_trending_large;
    }

    public void setThumbnail_trending_large(String thumbnail_trending_large) {
        this.thumbnail_trending_large = thumbnail_trending_large;
    }

    public String getThumbnail_regular_large() {
        return thumbnail_regular_large;
    }

    public void setThumbnail_regular_large(String thumbnail_regular_large) {
        this.thumbnail_regular_large = thumbnail_regular_large;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public boolean getTrending() {
        return trending;
    }

    public void setTrending(boolean trending) {
        this.trending = trending;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail_trending_large='" + thumbnail_trending_large + '\'' +
                ", thumbnail_regular_large='" + thumbnail_regular_large + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", isBookmarked=" + bookmarked +
                ", isTrending=" + trending +
                '}';
    }
}
