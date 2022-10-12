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
public class MovieServiceShould {

    @Mock
    MovieGateway movieGateway;

    @Test
    @DisplayName("invoke find in movie gateway")
    public void invoke_find_in_movie_gateway() {
        MovieService movieService = new MovieService(movieGateway);

        Movie movie = new Movie("Schindler's List", "/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg",
                8.6f, 13306, "1993-12-15");
        TmdbResponse tmdbResponseData = new TmdbResponse(1, List.of(movie));


        Mockito.when(movieGateway.find("Schindler")).thenReturn(tmdbResponseData);
        movieService.find("Schindler");

        Mockito.verify(movieGateway).find("Schindler");
    }
}
