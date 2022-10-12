package co.incubyte;

import io.micronaut.context.annotation.Bean;

import java.util.List;

@Bean
public class TvShowService {
    private TvShowGateway tvShowGateway;

    public TvShowService(TvShowGateway tvShowGateway) {
        this.tvShowGateway = tvShowGateway;
    }

    public List<TvShow> find(String name) {
        return tvShowGateway.find(name).getTvShow();
    }
}
