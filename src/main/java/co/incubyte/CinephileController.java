package co.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/cinephile")
public class CinephileController {

    @Inject
    GreeterService greeterService;

    @Get(uri = "/people/{id}", produces = "application/json")
    public Response index(String id) {
        return greeterService.greet(id);
    }
}
