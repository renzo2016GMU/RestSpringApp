package org.demo.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
class PersonRestController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/persons")
    Collection<Person> persons() {
        return this.personRepository.findAll();
    }
}
