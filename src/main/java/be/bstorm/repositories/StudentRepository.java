package be.bstorm.repositories;

import be.bstorm.models.entities.persons.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
