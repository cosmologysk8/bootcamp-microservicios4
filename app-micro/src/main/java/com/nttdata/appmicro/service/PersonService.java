package com.nttdata.appmicro.service;

import com.nttdata.appmicro.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class PersonService {

    public Flux<Person> allPerson(){
        Flux<Person> person1 = WebClient.create("http://localhost:8080/person-list-1").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> person2 = WebClient.create("http://localhost:8080/person-list-2").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> person3 = WebClient.create("http://localhost:8080/person-list-3").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> person4 = WebClient.create("http://localhost:8080/person-list-4").get().retrieve().bodyToFlux(Person.class);

        Flux<Person> allPerson = Flux.merge(person1,person2,person3,person4);
        return allPerson;
    }


}
