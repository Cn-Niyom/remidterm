package sit.remidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.remidterm.model.Employees;
import sit.remidterm.model.Offices;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private Offices office;
    private Employees reportsTo;
    private String jobTitle;

    public String getOffice() {
        if (office == null) {
            return null;
        }
        return office.getOfficeCode();
    }

    public String getReportsTo() {
        if (reportsTo == null) {
            return null;
        }
        return reportsTo.getFirstName() + " " + reportsTo.getLastName();
    }

}
