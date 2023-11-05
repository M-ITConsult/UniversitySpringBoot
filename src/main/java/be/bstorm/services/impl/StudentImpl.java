package be.bstorm.services.impl;

import be.bstorm.models.entities.persons.Student;
import be.bstorm.repositories.StudentRepository;
import be.bstorm.services.StudentService;

import java.util.List;

public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) { studentRepository.save(student); }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findManyByName(String firstname) {
        return null; /// TODO: 11/5/2023 mettre query dans le repo
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void update(Long id, Student student) {
        Student existingStudent = findById(id);
        existingStudent.setLastname(student.getLastname());
        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setAddress(student.getAddress());
        studentRepository.save(existingStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
