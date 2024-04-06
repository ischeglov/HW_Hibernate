package netology.hw_hibernate.controller;


import lombok.AllArgsConstructor;
import netology.hw_hibernate.entity.Person;
import netology.hw_hibernate.service.PersonService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping("/persons/by-city")
    @Secured({"ROLE_READ"})
    public List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed({"ROLE_WRITE"})
    public List<Person> getPersonsByAgeLess(@RequestParam(value = "age", required = false) int age) {
        return personService.getPersonsByAgeLess(age);
    }

    @GetMapping("/persons/by-name")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "surname", required = false) String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/hi")
    @PreAuthorize("#username == authentication.principal.username")
    public String hiUser(String username) {
        return "Hi " + username;
    }
}
