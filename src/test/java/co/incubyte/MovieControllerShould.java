package co.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieControllerShould {

    @Mock
    MovieService movieService;

    @Test
    @DisplayName("invoke find in movie service")
    public void invoke_find_in_movie_service() {
        MovieController movieController = new MovieController(movieService);
        movieController.find("Schindler");
        verify(movieService).find("Schindler");
    }
}
