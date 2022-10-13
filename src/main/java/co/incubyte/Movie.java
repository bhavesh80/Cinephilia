package co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private String name;
    private String image;
    private float rating;
    private int count;
    private String releaseDate;

    private int id;

    public Movie(@JsonProperty("title") String name, @JsonProperty("poster_path") String image, @JsonProperty("vote_average") float rating, @JsonProperty("vote_count") int count, @JsonProperty("release_date") String releaseDate,@JsonProperty("id") int id) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.count = count;
        this.releaseDate = releaseDate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }

    public int getCount() {
        return count;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
