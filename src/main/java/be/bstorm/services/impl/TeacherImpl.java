package be.bstorm.services.impl;

import be.bstorm.models.entities.persons.Teacher;
import be.bstorm.repositories.TeacherRepository;
import be.bstorm.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TeacherImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    public TeacherImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(Teacher teacher) {
        teacherRepository.save(teacher);
    }
    @Override
    public List<Teacher> findAll() { return teacherRepository.findAll();}
    @Override
    public List<Teacher> findManyByName(String firstname) { return teacherRepository.searchByFirstName(firstname.toLowerCase());}
    @Override
    public void deleteAll() { teacherRepository.deleteAll();}
    @Override
    public Teacher findById(Long id) { return teacherRepository.findById(id).orElseThrow(RuntimeException::new);}
    @Override
    public void update(Long id, Teacher teacher) {
        Teacher existingTeacher = findById(id);
        existingTeacher.setFirstname(teacher.getFirstname());
        existingTeacher.setLastname(teacher.getLastname());
        existingTeacher.setAddress(teacher.getAddress());
    }

    @Override
    public void delete(Long id) { teacherRepository.deleteById(id);}
}
