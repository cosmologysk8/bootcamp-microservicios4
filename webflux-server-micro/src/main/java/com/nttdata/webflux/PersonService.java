package com.nttdata.webflux;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class PersonService {

    public Flux<Person> person1 = WebClient.create("http://localhost:8080/person-list-1").get().retrieve().bodyToFlux(Person.class);
    public Flux<Person> person2 = WebClient.create("http://localhost:8080/person-list-2").get().retrieve().bodyToFlux(Person.class);
    public Flux<Person> person3 = WebClient.create("http://localhost:8080/person-list-3").get().retrieve().bodyToFlux(Person.class);
    public Flux<Person> person4 = WebClient.create("http://localhost:8080/person-list-4").get().retrieve().bodyToFlux(Person.class);

}
