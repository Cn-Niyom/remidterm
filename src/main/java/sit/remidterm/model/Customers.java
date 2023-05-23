package sit.remidterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @Column(name = "customerNumber", nullable = false)
    private Integer customerNumber;
    @Column(name = "customerName", nullable = false)
    private String customerName;
    @Column(name = "contactLastName", nullable = false)
    private String contactLastName;
    @Column(name = "contactFirstName", nullable = false)
    private String contactFirstName;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "addressLine1", nullable = false)
    private String addressLine1;
    @Column(name = "addressLine2")
    private String addressLine2;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "country", nullable = false)
    private String country;
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employees salesRepEmployeeNumber;
    @Column(name = "creditLimit")
    private Double creditLimit;
    @Column(name = "password" , nullable = false)
    private String password;
}
