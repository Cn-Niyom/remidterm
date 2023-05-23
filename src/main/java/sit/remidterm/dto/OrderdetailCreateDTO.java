package sit.remidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderdetailCreateDTO {
    private Integer orderNumber;
    private String productCode;
    private Integer quantityOrdered;
    private Double priceEach;
    private Integer orderLineNumber;
}
