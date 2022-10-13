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
    @Client("https://api.themoviedb.org/3/")
    HttpClient client;

    public TmdbResponse find(String name) {
        return client.toBlocking().retrieve(HttpRequest.GET("search/movie?api_key=71ef5befeacf953e353b1497fe5b64cb&query=" + URLEncoder.encode(name, StandardCharsets.UTF_8)),
                TmdbResponse.class);
    }

    public MovieDetail getById(int id) {
        var uri = "movie/" + id + "?api_key=e470560acfb347655d8af373c29aba11";
        System.out.println(uri);
        return client.toBlocking()
                .retrieve(HttpRequest.GET(uri),
                        MovieDetail.class);
    }
}
