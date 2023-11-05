package be.bstorm.models.dtos.student;

import be.bstorm.models.entities.persons.Student;


public record StudentShortRecord(String firstName, String lastName) {
    public static StudentShortRecord fromEntity(Student student) {
        return new StudentShortRecord(student.getFirstname(),student.getLastname());
    }
}
