package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.remidterm.dto.OrderCreateDTO;
import sit.remidterm.model.Customers;
import sit.remidterm.model.Orders;
import sit.remidterm.repository.CustomersRepository;
import sit.remidterm.repository.OrderdetailsRepository;
import sit.remidterm.repository.OrdersRepository;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private OrderdetailsRepository orderdetailsRepository;
    public List<Orders> getOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrders(Integer orderNumber) {
        return ordersRepository.findById(orderNumber).orElseThrow();
    }

    public Orders createOrder(OrderCreateDTO createOrder) {
        Orders orders = new Orders();
        orders.setOrderNumber(createOrder.getOrderNumber());
        orders.setOrderDate(createOrder.getOrderDate());
        orders.setRequiredDate(createOrder.getRequiredDate());
        orders.setShippedDate(createOrder.getShippedDate());
        orders.setStatus(createOrder.getStatus());
        orders.setComments(createOrder.getComments());
        Customers customers = customersRepository.findById(createOrder.getCustomerNumber()).orElseThrow();
        orders.setCustomer(customers);
        return ordersRepository.saveAndFlush(orders);
    }

    public Orders updateOrder(Integer id, OrderCreateDTO createDTO) {
        Orders orders = ordersRepository.findById(id).orElseThrow();
        if (createDTO.getOrderNumber() != null) {
            orders.setOrderNumber(createDTO.getOrderNumber());
        }
        if (createDTO.getOrderDate() != null) {
            orders.setOrderDate(createDTO.getOrderDate());
        }
        if (createDTO.getRequiredDate() != null) {
            orders.setRequiredDate(createDTO.getRequiredDate());
        }
        if (createDTO.getShippedDate() != null) {
            orders.setShippedDate(createDTO.getShippedDate());
        }
        if (createDTO.getStatus() != null) {
            orders.setStatus(createDTO.getStatus());
        }
        if (createDTO.getComments() != null) {
            orders.setComments(createDTO.getComments());
        }
        if (createDTO.getCustomerNumber() != null) {
            Customers customers = customersRepository.findById(createDTO.getCustomerNumber()).orElseThrow();
            orders.setCustomer(customers);
        }
        return ordersRepository.saveAndFlush(orders);
    }

    public List<Orders> getOrderByCustomer(Integer customerNumber) {
        return ordersRepository.findByCustomer_CustomerNumber(customerNumber);
    }

    public void deleteByCustomerNumber(Integer customerNumber) {
        List<Orders> orders = ordersRepository.findByCustomer_CustomerNumber(customerNumber);
        for (Orders order : orders) {
            try {
                orderdetailsRepository.deleteByOrder_OrderNumber(order.getOrderNumber());
                orderdetailsRepository.flush();
            } catch (Exception e) {
                System.out.println("No orderdetails");
            }
        }
        ordersRepository.deleteByCustomer_CustomerNumber(customerNumber);
        ordersRepository.flush();
    }
}
