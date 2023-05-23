package sit.remidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.remidterm.model.Employees;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Employees salesRepEmployeeNumber;
    private Double creditLimit;

    public String getSalesRepEmployeeNumber() {
        if (salesRepEmployeeNumber == null) {

            return null;
        }
        return salesRepEmployeeNumber.getFirstName() + " " + salesRepEmployeeNumber.getLastName();
    }
}
