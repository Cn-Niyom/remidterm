package sit.remidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.remidterm.model.Customers;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Customers customer;
    private String checkNumber;
    private String paymentDate;
    private Double amount;

    public Integer getCustomer() {
        if (customer == null) return null;
        return customer.getCustomerNumber();
    }

}
