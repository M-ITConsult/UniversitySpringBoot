package be.bstorm.models.dtos.student;
import be.bstorm.models.entities.persons.Student;
import lombok.Data;

@Data
public class StudentShortDTO {
    private Long id;
    private String lastName;
    private String firstName;

    public static StudentShortDTO fromEntity(Student student) {
        StudentShortDTO dto = new StudentShortDTO();
        dto.setLastName(student.getLastname());
        dto.setFirstName(student.getFirstname());
        return dto;
    }
}
