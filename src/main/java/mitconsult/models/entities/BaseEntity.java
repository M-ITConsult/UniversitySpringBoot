package mitconsult.models.entities;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor @NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> {
    @Id
    @Getter
    private T id;

}
