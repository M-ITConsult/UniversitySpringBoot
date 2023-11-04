package be.bstorm.models.entities;

import be.bstorm.models.entities.persons.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString(of = {"name","summary"}) @EqualsAndHashCode(of = {"name","summary"}, callSuper = false)
public class Course extends BaseEntity<String>{

    @Column(length = 50,nullable = false,unique = true)
    @Setter
    private String name;

    @Setter
    private String summary;

    @ManyToOne(fetch = FetchType.EAGER)
    @Setter
    private Teacher teacher;

    //Si on voulait gerer la bidirectionalité
//    @ManyToMany(mappedBy = "courses")
//    private Set<Branch> branches;
}
