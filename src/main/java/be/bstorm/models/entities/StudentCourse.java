package be.bstorm.models.entities;

import be.bstorm.models.entities.persons.Student;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Entity
@ToString @EqualsAndHashCode(callSuper = false)
//Extend BaseRelation car on a ici une @EmbeddedId plutot qu'un @Id
//Le type de cet attribut annoté @EmbeddedId et le type de la classe imbriquée ( StudentCourseId)
//Nous faisons ceci dans le cas d'une many to many que l'on doit gerer manuellement et où l'on veut comme PK une clef composite des deux FK
public class StudentCourse extends BaseRelation<StudentCourse.StudentCourseId> {

    //La many to many de base devient une double @ManyToOne
    @ManyToOne(fetch = FetchType.EAGER)
    //@MapsId sert a mapper l'id composite
    //On dit que l'id du student devra etre stocker dans StudentCourseId(studentId)
    @MapsId("studentId")
    @Setter
    private Student student;

    //Tout pareil que Student mais avec course
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("courseId")
    @Setter
    private Course course;

    @Setter
    @Column(nullable = false)
    private int year;

    @Embeddable
    public static class StudentCourseId implements Serializable {

        @Getter @Setter
        private String studentId;
        @Getter @Setter
        private String courseId;
    }
}
