package mitconsult.models.entities;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> {
    @Id
    private T id;

}
