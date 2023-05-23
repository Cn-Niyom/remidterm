package sit.remidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.remidterm.model.Orders;
import sit.remidterm.model.Products;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderdetailsDTO {
    private Orders order;
    private Products product;
    private Integer quantityOrdered;
    private Double priceEach;
    private Integer orderLineNumber;

    public Integer getOrder() {
        if (order == null)
            return null;
        return order.getOrderNumber();
    }

    public String getProduct() {
        if (product == null)
            return null;
        return product.getProductName();
    }
}
