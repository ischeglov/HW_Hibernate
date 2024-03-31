package netology.hw_hibernate.service;

import lombok.AllArgsConstructor;
import netology.hw_hibernate.entity.Person;
import netology.hw_hibernate.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        return personRepository.findPersonByCity(city);
    }

    @Transactional
    public List<Person> getPersonsByAgeLess(int age) {
        return personRepository.findPersonByContactAgeLessThanOrderByContactAge(age);
    }

    @Transactional
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findFirstPersonByContactNameAndContactSurname(name,surname);
    }
}
