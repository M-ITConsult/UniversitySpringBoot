package mitconsult.models.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(nullable = false, length = 50)
    private String street;
    @Column(nullable = false, length = 10)
    private String number;

    @Column(nullable = false, length = 6)
    private String zipcode;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 50)
    private String country;

}