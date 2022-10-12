package co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TmdbTvShowResponse {

    private int page;
    private List<TvShow> tvShow;

    public <E> TmdbTvShowResponse(@JsonProperty("page") int page,@JsonProperty("results") List<TvShow> tvShow) {
        this.page = page;
        this.tvShow = tvShow;
    }

    public int getPage() {
        return page;
    }

    public List<TvShow> getTvShow() {
        return tvShow;
    }
}
