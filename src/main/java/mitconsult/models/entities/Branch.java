package mitconsult.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Branch extends BaseEntity<String> {

    @Column(nullable = false, length = 50)
    private String name;
}
