package be.bstorm.repositories;

import be.bstorm.models.entities.persons.Student;
import be.bstorm.models.entities.persons.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstnameContainingIgnoreCase(String firstname);

    @Query("select s from Student s where upper(s.firstname) like %:firstname%")
    List<Student> searchByFirstName(@Param("firstname") String firstname);

}
