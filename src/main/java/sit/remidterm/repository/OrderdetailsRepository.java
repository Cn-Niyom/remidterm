package sit.remidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.remidterm.model.Orderdetails;
import sit.remidterm.model.Orders;
import sit.remidterm.model.Products;
import sit.remidterm.utils.OrderdetailsID;

import java.beans.Transient;
import java.util.List;

public interface OrderdetailsRepository extends JpaRepository<Orderdetails, OrderdetailsID> {

    void deleteByOrder_OrderNumber(Integer orderNumber);
    List<Orderdetails> findByOrder_OrderNumber(Integer orderNumber);

    List<Orderdetails> findByProduct_ProductCode(String productCode);

    Orderdetails findByOrder_OrderNumberAndProduct_ProductCode(Integer orderNumber, String productCode);

    void deleteByOrder_OrderNumberAndProduct_ProductCode(Integer orderNumber, String productCode);


}
