package com.nttdata.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerTest {

    Person person1 = new Person("Juan", "Perez", 30);
    Person person2 = new Person("Fran", "Romero", 34);
    Person person3 = new Person("Luis", "Guzman", 20);
    Person person4 = new Person("Pepe", "Garcia", 15);
    Person person5 = new Person("Antonio", "Bellido", 24);
    Person person6 = new Person("Alberto", "Gomez", 37);


    @GetMapping("/person-list-1")
    public Flux<Person> personList1(){
    List<Person> personsList1 = new ArrayList<>();
        personsList1.add(person1);
        personsList1.add(person2);

        return Flux.fromIterable(personsList1).delaySequence(Duration.ofSeconds(3));
    }

    @GetMapping("/person-list-2")
    public Flux<Person> personList2(){
        List<Person> personsList2 = new ArrayList<>();

        personsList2.add(person3);
        return Flux.fromIterable(personsList2).delaySequence(Duration.ofSeconds(2));
    }

    @GetMapping("/person-list-3")
    public Flux<Person> personList3(){
        List<Person> personsList3 = new ArrayList<>();
        personsList3.add(person4);
        personsList3.add(person5);

        return Flux.fromIterable(personsList3).delaySequence(Duration.ofSeconds(3));
    }

    @GetMapping("/person-list-4")
    public Flux<Person> personList4(){
        List<Person> personsList4 = new ArrayList<>();
        personsList4.add(person6);
        return Flux.fromIterable(personsList4).delaySequence(Duration.ofSeconds(2));
    }

}
