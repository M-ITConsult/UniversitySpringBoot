package be.bstorm.services.impl;

import be.bstorm.models.entities.persons.Teacher;
import be.bstorm.repositories.TeacherRepository;
import be.bstorm.services.TeacherService;

import java.util.List;
import java.util.Locale;

public class TeacherImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    public TeacherImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository; }

    public void create(Teacher teacher) { teacherRepository.save(teacher);}

    public List<Teacher> findAll() { return teacherRepository.findAll();}

    public List<Teacher> findManyByName(String firstName) { return teacherRepository.searchByTitle(firstName.toLowerCase());}

    public void deleteAll() { teacherRepository.deleteAll();}

    public Teacher findById(Long id) { return teacherRepository.findById(id).orElseThrow(RuntimeException::new);}

    public void update(Long id, Teacher teacher) {
        Teacher existingTeacher = findById(id);
        existingTeacher.setFirstname(teacher.getFirstname());
        existingTeacher.setLastname(teacher.getLastname());
        existingTeacher.setAddress(teacher.getAddress());
    }

    public void delete(Long id) { teacherRepository.deleteById(id);}
}
