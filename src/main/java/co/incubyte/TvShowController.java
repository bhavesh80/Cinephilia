package co.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.util.List;

@Controller("tv_shows")
public class TvShowController {

    private TvShowService tvShowService;

    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @Get
    public List<TvShow> find(@QueryValue("query") String name) {
        return tvShowService.find(name);
    }
}
