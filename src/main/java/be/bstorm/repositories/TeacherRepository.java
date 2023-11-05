package be.bstorm.repositories;

import be.bstorm.models.entities.persons.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findTeachersByNameContainingIgnoreCase(String firstName);

    @Query("select t from Teacher t where upper(t.firstname) like %:firstname%")
    List<Teacher> searchByTitle(@Param("firstname") String firstName);

}
