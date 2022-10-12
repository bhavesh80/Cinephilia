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
public class TvShowServiceShould {

    @Mock
    TvShowGateway tvShowGateway;

    @Test
    @DisplayName("invoke find in tvShow gateway")
    public void invoke_find_in_tv_show_gateway() {

        TvShowService tvShowService = new TvShowService(tvShowGateway);

        TvShow tvShow = new TvShow("The Big Bang Theory", "/ooBGRQBdbGzBxAVfExiO8r7kloA.jpg", 7.8f, 9151, "2007-09-24");
        TmdbTvShowResponse tmdbTvShowResponseData = new TmdbTvShowResponse(1, List.of(tvShow));

        Mockito.when(tvShowGateway.find("the big bang theory")).thenReturn(tmdbTvShowResponseData);
        tvShowService.find("the big bang theory");

        Mockito.verify(tvShowGateway).find("the big bang theory");

    }
}
