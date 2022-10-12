package co.incubyte;

import io.micronaut.context.annotation.Bean;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Bean
public class MovieGateway {

    @Inject
    @Client("https://api.themoviedb.org/3/search/movie")
    HttpClient client;

    public TmdbResponse find(String name) {
        return client.toBlocking().retrieve(HttpRequest.GET("?api_key=71ef5befeacf953e353b1497fe5b64cb&query=" + URLEncoder.encode(name, StandardCharsets.UTF_8)),
                TmdbResponse.class);
    }
}
