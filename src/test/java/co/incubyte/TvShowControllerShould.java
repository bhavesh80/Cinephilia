package co.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TvShowControllerShould {

    @Mock
    TvShowService tvShowService;

    @Test
    @DisplayName("invoke find in tvShow service")
    public void invoke_find_in_tv_show_service() {

        TvShowController tvShowController = new TvShowController(tvShowService);
        tvShowController.find("the big bang theory");
        verify(tvShowService).find("the big bang theory");
    }
}
