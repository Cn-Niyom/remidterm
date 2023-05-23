package sit.remidterm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offices")
public class Offices {
    @Id
    @Column(name = "officeCode", nullable = false)
    private String officeCode;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "addressLine1", nullable = false)
    private String addressLine1;
    @Column(name = "addressLine2")
    private String addressLine2;
    @Column(name = "state")
    private String state;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "postalCode", nullable = false)
    private String postalCode;
    @Column(name = "territory", nullable = false)
    private String territory;
}
