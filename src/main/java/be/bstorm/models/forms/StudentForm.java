package be.bstorm.models.forms;

import be.bstorm.models.entities.persons.Student;
import be.bstorm.models.entities.persons.Teacher;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentForm {
    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;
    private String lastName;


    public Student toEntity() {
        Student student = new Student();
        student.setFirstname(this.firstName);
        student.setLastname(this.lastName);
        return student;
    }

    public static StudentForm fromEntity(Student student) {
        StudentForm studentForm = new StudentForm();
        studentForm.setFirstName(student.getFirstname());
        studentForm.setLastName(student.getLastname());
        return studentForm;
    }
}
