package be.bstorm.models.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Annotation Jpa pour definir que cette classe peut etre embarquée
//C'est a dire devient une sorte d'extention a la classe qui l'embarque
@Embeddable
@Getter @Setter
@ToString @EqualsAndHashCode
public class Address {

    @Column(nullable = false,length = 50)
    private String street;
    @Column(nullable = false,length = 10)
    private String number;
    @Column(nullable = false,length = 6)
    private String zipcode;
    @Column(nullable = false,length = 100)
    private String city;
    @Column(nullable = false,length = 50)
    private String country;

}
