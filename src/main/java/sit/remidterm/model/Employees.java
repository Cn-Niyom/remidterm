package sit.remidterm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "employees")
public class Employees {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    private Integer employeeNumber;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "extension", nullable = false)
    private String extension;
    @Column(name = "email", nullable = false)
    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "officeCode", nullable = false)
    private Offices officeCode;

    @ManyToOne
    @JoinColumn(name = "employeeNumber", insertable = false, updatable = false)
    private Employees reportsTo;

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;
}
