package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=BV4B0P0-2CM439J-P917ZP4-H0KD9M9&rating.kp=8-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie/{idFilm}?token=BV4B0P0-2CM439J-P917ZP4-H0KD9M9")
    Single<TrailerResponse> loadTrailers(@Path("idFilm") int id);

    @GET("review?token=BV4B0P0-2CM439J-P917ZP4-H0KD9M9")
    Single<ReviewResponse> loadReviews(@Query("movieId") int movieId);
}
