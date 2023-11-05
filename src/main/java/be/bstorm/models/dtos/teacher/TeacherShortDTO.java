package be.bstorm.models.dtos.teacher;

import be.bstorm.models.entities.persons.Teacher;
import lombok.Data;

@Data
public class TeacherShortDTO {
    private Long id;
    private String lastName;
    private String firstName;

    public static TeacherShortDTO fromEntity(Teacher teacher) {
        TeacherShortDTO dto = new TeacherShortDTO();
        dto.setLastName(teacher.getLastname());
        dto.setFirstName(teacher.getFirstname());
        return dto;
    }
}
