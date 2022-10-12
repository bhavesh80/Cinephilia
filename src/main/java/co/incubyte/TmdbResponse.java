package co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TmdbResponse {
    private int page;
    private List<Movie> movies;

    public TmdbResponse(@JsonProperty("page") int page, @JsonProperty("results") List<Movie> movies) {
        this.page = page;
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
