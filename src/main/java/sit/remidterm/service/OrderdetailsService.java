package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sit.remidterm.model.Orderdetails;
import sit.remidterm.repository.OrderdetailsRepository;


import java.util.List;

@Service
public class OrderdetailsService {
    @Autowired
    private OrderdetailsRepository orderdetailsRepository;
    public List<Orderdetails> getOrderdetails() {
        return orderdetailsRepository.findAll();
    }

    public List<Orderdetails> findByOrderNumber(Integer orderNumber) {
        return orderdetailsRepository.findByOrder_OrderNumber(orderNumber);
    }

    public Orderdetails createOrderdetails(Orderdetails orderdetails) {
        return orderdetailsRepository.saveAndFlush(orderdetails);
    }

    public Orderdetails upOrderdetails(Orderdetails orderdetails, @PathVariable Integer orderNumber, @PathVariable String productCode) {
        Orderdetails orderdetails1 = findByOrderNumberAndProductCode(orderNumber, productCode);
        orderdetails1.setOrderLineNumber(orderdetails.getOrderLineNumber());
        orderdetails1.setPriceEach(orderdetails.getPriceEach());
        orderdetails1.setQuantityOrdered(orderdetails.getQuantityOrdered());
        return orderdetailsRepository.saveAndFlush(orderdetails1);
    }

    public void deleteOrderdetailsByOrderNumber(Integer orderNumber) {
        orderdetailsRepository.deleteByOrder_OrderNumber(orderNumber);
    }

    public List<Orderdetails> findByProductCode(String productCode) {
        return orderdetailsRepository.findByProduct_ProductCode(productCode);
    }

    public Orderdetails findByOrderNumberAndProductCode(Integer orderNumber, String productCode) {
        return orderdetailsRepository.findByOrder_OrderNumberAndProduct_ProductCode(orderNumber, productCode);
    }

    public void deleteOrderdetailsByOrderNumberAndProductCode(Integer orderNumber, String productCode) {
        orderdetailsRepository.deleteByOrder_OrderNumberAndProduct_ProductCode(orderNumber, productCode);
    }
}
