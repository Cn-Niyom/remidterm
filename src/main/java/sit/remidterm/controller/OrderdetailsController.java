package sit.remidterm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.dto.OrderdetailsDTO;
import sit.remidterm.model.Orderdetails;
import sit.remidterm.service.OrderdetailsService;
import sit.remidterm.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderdetailsController {
    @Autowired
    private OrderdetailsService orderdetailsService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
//    public List<Orderdetails> getOrderdetails() {
//        return orderdetailsService.getOrderdetails();
//    }
    public List<OrderdetailsDTO> getOrderdetails() {
        return listMapper.mapList(orderdetailsService.getOrderdetails(), OrderdetailsDTO.class, modelMapper);
    }

    @GetMapping("/orderNumber/{orderNumber}")
//    public List<Orderdetails> getOrderdetailsByOrderNumber(@PathVariable Integer orderNumber) {
//        return orderdetailsService.findByOrderNumber(orderNumber);
//    }
    public List<OrderdetailsDTO> getOrderdetailsByOrderNumber(@PathVariable Integer orderNumber) {
        return listMapper.mapList(orderdetailsService.findByOrderNumber(orderNumber), OrderdetailsDTO.class, modelMapper);
    }

    @GetMapping("/productCode/{productCode}")
//    public List<Orderdetails> getOrderdetailsByProductCode(@PathVariable String productCode) {
//        return orderdetailsService.findByProductCode(productCode);
//    }
    public List<OrderdetailsDTO> getOrderdetailsByProductCode(@PathVariable String productCode) {
        return listMapper.mapList(orderdetailsService.findByProductCode(productCode), OrderdetailsDTO.class, modelMapper);
    }

    @GetMapping("/{orderNumber}/{productCode}")
//    public Orderdetails getOrderdetailsByOrderNumberAndProductCode(@PathVariable Integer orderNumber, @PathVariable String productCode) {
//        return orderdetailsService.findByOrderNumberAndProductCode(orderNumber, productCode);
//    }
    public OrderdetailsDTO getOrderdetailsByOrderNumberAndProductCode(@PathVariable Integer orderNumber, @PathVariable String productCode) {
        return modelMapper.map(orderdetailsService.findByOrderNumberAndProductCode(orderNumber, productCode), OrderdetailsDTO.class);
    }

    @PostMapping("")
//    public Orderdetails createOrderdetails(@RequestBody Orderdetails orderdetails) {
//        return orderdetailsService.createOrderdetails(orderdetails);
//    }
    public OrderdetailsDTO createOrderdetails(@RequestBody Orderdetails orderdetails) {
        return modelMapper.map(orderdetailsService.createOrderdetails(orderdetails), OrderdetailsDTO.class);
    }

    @PutMapping("/{orderNumber}/{productCode}")
//    public Orderdetails updateOrderdetails(@RequestBody Orderdetails orderdetails, @PathVariable Integer orderNumber, @PathVariable String productCode) {
//
//        return orderdetailsService.upOrderdetails(orderdetails, orderNumber, productCode);
//    }
    public OrderdetailsDTO updateOrderdetails(@RequestBody Orderdetails orderdetails, @PathVariable Integer orderNumber, @PathVariable String productCode) {

        return modelMapper.map(orderdetailsService.updateOrderdetails(orderdetails, orderNumber, productCode), OrderdetailsDTO.class);
    }

    @DeleteMapping("/{orderNumber}")
    public void deleteOrderdetailsByOrderNumber(@PathVariable Integer orderNumber) {
        orderdetailsService.deleteOrderdetailsByOrderNumber(orderNumber);
    }

    @DeleteMapping("/{orderNumber}/{productCode}")
    public void deleteOrderdetailsByOrderNumberAndProductCode(@PathVariable Integer orderNumber, @PathVariable String productCode) {
        orderdetailsService.deleteOrderdetailsByOrderNumberAndProductCode(orderNumber, productCode);
    }

}
