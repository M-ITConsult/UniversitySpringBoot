package mitconsult.models.entities.persons;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mitconsult.models.entities.Person;
import mitconsult.models.entities.StudentCourse;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Student extends Person {

    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> studentCourseSet;

    public Set<StudentCourse> getStudentCourseSet() {
        return Set.copyOf(this.studentCourseSet);
    }

    public void addStudentCourse(StudentCourse studentCourse) {
        this.studentCourseSet.add(studentCourse);
    }

    public void removeStudentCourse(StudentCourse studentCourse) {
        this.studentCourseSet.remove(studentCourse);
    }
}
