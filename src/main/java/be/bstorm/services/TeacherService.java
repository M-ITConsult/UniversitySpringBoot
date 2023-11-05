package be.bstorm.services;

import be.bstorm.models.entities.persons.Teacher;

import java.util.List;

public interface TeacherService {

    void create(Teacher teacher);

    List<Teacher> findAll();

    List<Teacher> findManyByName(String lastName);

    void deleteAll();

    Teacher findById(Long id);

    void update(Long id, Teacher teacher);

    void delete(Long id);
}
