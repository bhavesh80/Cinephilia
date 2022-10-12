package co.incubyte;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class CinephileControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testIndex() throws Exception {
        String retrieve = client.toBlocking().retrieve("/cinephile/person/TomCruise");
        assertEquals("Hello TomCruise!!!", retrieve);
    }


}
