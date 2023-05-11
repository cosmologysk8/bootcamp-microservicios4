package com.nttdata.appmicro.controller;

import com.nttdata.appmicro.Person;
import com.nttdata.appmicro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import reactor.core.publisher.Flux;

@Controller
public class PersonListController {

    @Autowired
    PersonService personService;

    public String personList(final Model model){
        final Flux<Person> personList = personService.allPerson();
        model.addAllAttributes("personlist", personList);
        return "personlist";
    }

}
