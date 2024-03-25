package netology.hw_hibernate.service;

import lombok.AllArgsConstructor;
import netology.hw_hibernate.entity.Person;
import netology.hw_hibernate.repository.PersonRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
