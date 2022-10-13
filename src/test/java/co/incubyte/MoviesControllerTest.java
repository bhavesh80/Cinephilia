package co.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class MoviesControllerTest {
    @Inject
    @Client("/movies")
    HttpClient client;

    @Test
    @DisplayName("it should find movie data")
    public void it_should_find_movie_data() {
        List<Movie> movies = client.toBlocking().retrieve(HttpRequest.GET("?query=Schindler"),
                Argument.listOf(Movie.class));

        assertThat(movies.size()).isGreaterThan(0);
        assertThat(movies.get(0).getName().length()).isGreaterThan(0);
        assertThat(movies.get(0).getImage().length()).isGreaterThan(0);
        assertThat(movies.get(0).getName()).isEqualTo("Schindler's List");
        assertThat(movies.get(0).getRating()).isGreaterThan(0.0f);
        assertThat(movies.get(0).getCount()).isGreaterThan(0);
        assertThat(movies.get(0).getReleaseDate()).isEqualTo("1993-12-15");
        assertThat(movies.get(0).getId()).isEqualTo(424);

    }

    @Test
    @DisplayName("should get movie information by id")
    public void should_get_movie_information_by_id() {
        MovieDetail movieDetail = client.toBlocking()
                .retrieve(HttpRequest.GET("361743"), MovieDetail.class);
        assertThat(movieDetail).isNotNull();
        assertThat(movieDetail.getBackDropPath()).isEqualTo("/odJ4hx6g6vBt4lBWKFD1tI8WS4x.jpg");
        assertThat(movieDetail.getOriginalLanguage()).isEqualTo("en");
        assertThat(movieDetail.getDuration()).isEqualTo(131);
        assertThat(movieDetail.getOverview()).startsWith(
                "After more than thirty years of service as one of the Navy");
    }
}
