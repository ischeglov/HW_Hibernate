package netology.hw_hibernate.repository;

import netology.hw_hibernate.entity.Contact;
import netology.hw_hibernate.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Component
public class DataEntity implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Person ivan = Person.builder().contact(Contact.builder()
                        .name("Ivan")
                        .surname("Shcheglov")
                        .age(36)
                        .build())
                .phoneNumber("+7 927 333-88-33")
                .city("Ufa")
                .build();

        Person anna = Person.builder().contact(Contact.builder()
                        .name("Anna")
                        .surname("Shcheglova")
                        .age(40)
                        .build())
                .phoneNumber("+7 927 888-33-88")
                .city("Moscow")
                .build();

        Person arseny = Person.builder().contact(Contact.builder()
                        .name("Arseny")
                        .surname("Shcheglov")
                        .age(18)
                        .build())
                .phoneNumber("+7 927 888-88-88")
                .city("Moscow")
                .build();
//        entityManager.persist(ivan);
//        entityManager.persist(anna);
//        entityManager.persist(arseny);
    }
}



