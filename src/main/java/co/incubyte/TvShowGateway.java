package co.incubyte;

import io.micronaut.context.annotation.Bean;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Bean
public class TvShowGateway {

    @Inject
    @Client("https://api.themoviedb.org/3/search/tv")
    HttpClient client;

    public TmdbTvShowResponse find(String name) {
        return client.toBlocking().retrieve(HttpRequest.GET("?api_key=71ef5befeacf953e353b1497fe5b64cb&query=" + URLEncoder.encode(name,StandardCharsets.UTF_8)),
                TmdbTvShowResponse.class);
    }
}
