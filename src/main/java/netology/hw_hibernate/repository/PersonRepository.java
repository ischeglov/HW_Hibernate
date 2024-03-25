package netology.hw_hibernate.repository;

import netology.hw_hibernate.entity.Person;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.city = :city");
        query.setParameter("city", city);
        List<Person> personsByCity = query.getResultList();

        return personsByCity;
    }
}
