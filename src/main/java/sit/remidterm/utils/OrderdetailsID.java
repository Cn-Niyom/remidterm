package sit.remidterm.utils;

import lombok.Setter;
import sit.remidterm.model.Orders;
import sit.remidterm.model.Products;

import java.io.Serializable;

@Setter
public class OrderdetailsID implements Serializable {
    private Orders order;
    private Products product;


}
