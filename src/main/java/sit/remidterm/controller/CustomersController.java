package sit.remidterm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.dto.CustomerCreateDTO;
import sit.remidterm.dto.CustomerDTO;
import sit.remidterm.dto.PageDto;
import sit.remidterm.service.CustomersService;
import sit.remidterm.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    @Autowired
    private CustomersService customersService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
//    public List<Customers> getCustomers() {
//        return customersService.getCustomers();
//    }
    public List<CustomerDTO> getCustomers() {
        return listMapper.mapList(customersService.getCustomers(), CustomerDTO.class, modelMapper);
    }
    @GetMapping("/pages")
    public PageDto<CustomerDTO> getCustomers(@RequestParam(defaultValue = "0") Integer pageNo,
                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                             @RequestParam(defaultValue = "customerNumber") String sortBy) {
        return listMapper.toPageDTO(customersService.getCustomers(pageNo, pageSize, sortBy), CustomerDTO.class, modelMapper);
    }

    @GetMapping("/{customerNumber}")
//    public Customers getCustomers(@PathVariable Integer customerNumber){
//        return customersService.getCustomers(customerNumber);
//    }
    public CustomerDTO getCustomers(@PathVariable Integer customerNumber) {
        return modelMapper.map(customersService.getCustomers(customerNumber), CustomerDTO.class);
    }

    @PostMapping("")
//    public Customers createCustomers(@RequestBody CustomerCreateDTO customers){
//        return customersService.createCustomers(customers);
//    }
    public CustomerDTO createCustomers(@RequestBody CustomerCreateDTO customers) {
        return modelMapper.map(customersService.createCustomers(customers), CustomerDTO.class);
    }

    @PutMapping("/{customerNumber}")
//    public Customers updateCustomers(@PathVariable Integer customerNumber, @RequestBody CustomerCreateDTO customers){
//        return customersService.updateCustomers(customerNumber, customers);
//    }
    public CustomerDTO updateCustomers(@PathVariable Integer customerNumber, @RequestBody CustomerCreateDTO customers) {
        return modelMapper.map(customersService.updateCustomers(customerNumber, customers), CustomerDTO.class);
    }

    @DeleteMapping("/{customerNumber}")
    public void deleteCustomers(@PathVariable Integer customerNumber) {
        customersService.deleteCustomers(customerNumber);
    }

}
