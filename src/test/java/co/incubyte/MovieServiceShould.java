package co.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MovieServiceShould {

    @Mock
    MovieGateway movieGateway;

    @Test
    @DisplayName("invoke find in api gateway")
    public void invoke_find_in_api_gateway() {
        MovieService movieService = new MovieService(movieGateway);

        movieService.find("Schindler");

        Mockito.verify(movieGateway).find("Schindler");

    }
}
