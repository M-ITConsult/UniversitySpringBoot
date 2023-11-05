package be.bstorm.models.forms;

import be.bstorm.models.entities.persons.Teacher;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TeacherForm {
    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;
    private String lastName;


    public Teacher toEntity() {
        Teacher teacher = new Teacher();
        teacher.setFirstname(this.firstName);
        teacher.setLastname(this.lastName);
        return teacher;
    }

    public static TeacherForm fromEntity(Teacher teacher) {
        TeacherForm teacherForm = new TeacherForm();
        teacherForm.setFirstName(teacher.getFirstname());
        teacherForm.setLastName(teacher.getLastname());
        return teacherForm;
    }
}
