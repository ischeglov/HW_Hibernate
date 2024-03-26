package netology.hw_hibernate.repository;

import netology.hw_hibernate.entity.Contact;
import netology.hw_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Contact> {

    List<Person> findPersonByCity(String city);

    List<Person> findPersonByContactAgeLessThanOrderByContactAge(int age);

    Optional<Person> findFirstPersonByContactNameAndContactSurname(String name, String surname);
}
