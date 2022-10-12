package co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MovieGatewayShould {

    @Mock
    MovieGateway movieGateway;

    @Test
    @DisplayName("find the movie and return the movie list")
    public void find_the_movie_and_return_the_movie_list() {
        Movie movie = new Movie("Schindler's List", "/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg",
                8.6f, 13306, "1993-12-15");
        TmdbResponse tmdbResponseData = new TmdbResponse(1, List.of(movie));

        Mockito.when(movieGateway.find("Schindler")).thenReturn(tmdbResponseData);
        TmdbResponse tmdbResponse = movieGateway.find("Schindler");
        Assertions.assertThat(tmdbResponse.getMovies().get(0)).isEqualTo(movie);

    }
}
