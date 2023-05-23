package sit.remidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.remidterm.model.Customers;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer orderNumber;
    private Date orderDate;
    private String status;
    private Customers customer;

    public String getCustomer() {
        if (customer == null) return "";
            return customer.getCustomerName()+" "+customer.getContactLastName()+" "+customer.getContactFirstName();
    }
}
