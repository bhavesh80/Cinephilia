package co.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@MicronautTest
public class TvShowControllerTest {
    @Inject
    @Client("/tv_shows")
    HttpClient client;

    @Test
    @DisplayName("it should find tv show data")
    public void it_should_find_tv_show_data() {

        List<TvShow> tvShows  = client.toBlocking().retrieve(HttpRequest.GET("?query="+URLEncoder.encode("the big bang theory",StandardCharsets.UTF_8)),
                Argument.listOf(TvShow.class));

        assertThat(tvShows.size()).isGreaterThan(0);
        assertThat(tvShows.get(0).getName()).isEqualTo("The Big Bang Theory");
        assertThat(tvShows.get(0).getImage().length()).isGreaterThan(0);
        assertThat(tvShows.get(0).getRating()).isGreaterThan(0);
        assertThat(tvShows.get(0).getCount()).isGreaterThan(0);
        assertThat(tvShows.get(0).getReleaseDate()).isEqualTo("2007-09-24");

    }
}
