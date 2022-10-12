package co.incubyte;

import io.micronaut.context.annotation.Bean;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

@Bean
public class GreeterService {

    Person person;
    @Inject
    @Client("https://jsonplaceholder.typicode.com/users/")
    HttpClient client;

    Response greet(String id) {
        Person responsePerson = client.toBlocking().retrieve(HttpRequest.GET("/" + id), Person.class);
        String name = responsePerson.getName();
        Response response = new Response("Hello", name);
        return response;
    }
}
