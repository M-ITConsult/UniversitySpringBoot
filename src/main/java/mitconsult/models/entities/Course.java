package mitconsult.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Course extends BaseEntity<String> {

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    private String summary;
}
