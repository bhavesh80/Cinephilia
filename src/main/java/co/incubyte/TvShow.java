package co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvShow {
    private String name;
    private String image;
    private float rating;
    private int count;
    private String releaseDate;

    public String getName() {
        return name;
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

    public TvShow(@JsonProperty("name") String name,@JsonProperty("poster_path") String image,@JsonProperty("vote_average") float rating,
                  @JsonProperty("vote_count") int count,@JsonProperty("first_air_date") String releaseDate) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.count = count;
        this.releaseDate = releaseDate;
    }



}
