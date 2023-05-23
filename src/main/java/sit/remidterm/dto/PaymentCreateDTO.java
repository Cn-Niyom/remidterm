package sit.remidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentCreateDTO {
    private Integer customerNumber;
    private String checkNumber;
    private String paymentDate;
    private Double amount;
}
