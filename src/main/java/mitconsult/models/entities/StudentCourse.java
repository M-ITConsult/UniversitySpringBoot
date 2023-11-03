package mitconsult.models.entities;

import jakarta.persistence.*;
import mitconsult.models.entities.persons.Student;
import java.io.Serializable;

@Entity
public class StudentCourse extends BaseRelation<StudentCourse.StudentCourseId> {

    @ManyToOne
    @MapsId("studentId")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    private Course course;
    @Column(nullable = false)
    private int year;

    @Embeddable
    public static class StudentCourseId implements Serializable {
        private String studentId;
        private String courseId;
    }
}
