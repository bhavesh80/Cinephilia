package co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDetail {
    private String backDropPath;
    private String originalLanguage;
    private int duration;
    private String overview;

    public MovieDetail(@JsonProperty("backdrop_path") String backDropPath, @JsonProperty("original_language") String originalLanguage, @JsonProperty("runtime") int duration, @JsonProperty("overview") String overview) {
        this.backDropPath = backDropPath;
        this.originalLanguage = originalLanguage;
        this.duration = duration;
        this.overview = overview;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public int getDuration() {
        return duration;
    }

    public String getOverview() {
        return overview;
    }
}
