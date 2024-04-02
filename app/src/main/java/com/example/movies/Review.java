package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class Review {
    @SerializedName("author")
    String author;
    @SerializedName("review")
    String review;
    @SerializedName("type")
    String type;

    public Review(String name, String review, String type) {
        this.author = name;
        this.review = review;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getReview() {
        return review;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Review{" +
                "author='" + author + '\'' +
                ", review='" + review + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
