package be.bstorm.models.dtos.teacher;

import be.bstorm.models.entities.persons.Teacher;

public record TeacherShortRecord (String firstName, String lastName) {
    public static TeacherShortRecord fromEntity(Teacher teacher) {
        return new TeacherShortRecord(teacher.getFirstname(),teacher.getLastname());
    }
}
