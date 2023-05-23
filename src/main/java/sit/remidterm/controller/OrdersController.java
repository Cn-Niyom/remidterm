package sit.remidterm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.dto.OrderCreateDTO;
import sit.remidterm.dto.OrderDTO;
import sit.remidterm.model.Orders;
import sit.remidterm.service.OrdersService;
import sit.remidterm.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersService orderService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public List<OrderDTO> getOrders() {
        return listMapper.mapList(orderService.getOrders(), OrderDTO.class, modelMapper);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Integer id) {
        return modelMapper.map(orderService.getOrders(id), OrderDTO.class);
    }

    @PostMapping("")
//    public Orders createOrder(@RequestBody OrderCreateDTO orders) {
//        return orderService.createOrder(orders);
//    }
    public OrderDTO createOrder(@RequestBody OrderCreateDTO orders) {
        return modelMapper.map(orderService.createOrder(orders), OrderDTO.class);
    }
    @PutMapping("/{id}")
//    public Orders updateOrder(@PathVariable Integer id, @RequestBody OrderCreateDTO orders) {
//        return orderService.updateOrder(id, orders);
//    }
    public OrderDTO updateOrder(@PathVariable Integer id, @RequestBody OrderCreateDTO orders) {
        return modelMapper.map(orderService.updateOrder(id, orders), OrderDTO.class);
    }
    @GetMapping("/customer/{id}")
    public List<OrderDTO> getOrderByCustomer(@PathVariable Integer id) {
        return listMapper.mapList(orderService.getOrderByCustomer(id), OrderDTO.class, modelMapper);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteOrderByCustomer(@PathVariable Integer id) {
        orderService.deleteByCustomerNumber(id);
    }
}
