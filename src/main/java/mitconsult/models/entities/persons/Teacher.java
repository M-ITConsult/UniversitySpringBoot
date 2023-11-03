package mitconsult.models.entities.persons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import mitconsult.models.entities.Person;


@Entity
public class Teacher extends Person {
    @Column(nullable = false, length = 50)
    private String title;

}
