package mitconsult.models.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor@NoArgsConstructor
public abstract class BaseRelation <T extends Serializable> {
    @EmbeddedId
    private T id;

}
