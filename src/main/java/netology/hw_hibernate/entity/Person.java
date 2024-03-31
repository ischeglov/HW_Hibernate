package netology.hw_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @EmbeddedId
    private Contact contact;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String phoneNumber;
}
