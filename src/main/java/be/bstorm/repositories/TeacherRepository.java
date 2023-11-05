package be.bstorm.repositories;

import be.bstorm.models.entities.persons.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
