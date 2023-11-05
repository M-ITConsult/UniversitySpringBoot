package be.bstorm.services;

import be.bstorm.models.entities.persons.Student;
import java.util.List;

public interface StudentService {

    void create(Student student);

    List<Student> findAll();

    List<Student> findManyByName(String firstname);

    void deleteAll();

    Student findById(Long id);

    void update(Long id, Student student);

    void delete(Long id);
}
