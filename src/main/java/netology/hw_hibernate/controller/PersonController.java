package netology.hw_hibernate.controller;


import lombok.AllArgsConstructor;
import netology.hw_hibernate.entity.Person;
import netology.hw_hibernate.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAgeLess(@RequestParam(value = "age", required = false) int age) {
        return personService.getPersonsByAgeLess(age);
    }

    @GetMapping("/persons/by-name")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "surname", required = false) String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }
}
