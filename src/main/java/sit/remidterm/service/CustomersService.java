package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.remidterm.dto.CustomerCreateDTO;
import sit.remidterm.model.Customers;
import sit.remidterm.model.Employees;
import sit.remidterm.repository.CustomersRepository;
import sit.remidterm.repository.EmployeesRepository;

import java.util.List;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }

    public Customers getCustomers(Integer customerNumber) {
        return customersRepository.findById(customerNumber).orElseThrow();
    }

    public Customers createCustomers(CustomerCreateDTO customers) {
        Customers customers1 = new Customers();
        return getCustomers(customers, customers1);
    }

    public Customers updateCustomers(Integer id, CustomerCreateDTO createDTO) {
        Customers customers = customersRepository.findById(id).orElseThrow();
        return getCustomers(createDTO, customers);
    }

    private Customers getCustomers(CustomerCreateDTO createDTO, Customers customers) {
        if (createDTO.getCustomerNumber() != null) {
            customers.setCustomerNumber(createDTO.getCustomerNumber());
        }
        if (createDTO.getCustomerName() != null) {
            customers.setCustomerName(createDTO.getCustomerName());
        }
        if (createDTO.getContactLastName() != null) {
            customers.setContactLastName(createDTO.getContactLastName());
        }
        if (createDTO.getContactFirstName() != null) {
            customers.setContactFirstName(createDTO.getContactFirstName());
        }
        if (createDTO.getPhone() != null) {
            customers.setPhone(createDTO.getPhone());
        }
        if (createDTO.getAddressLine1() != null) {
            customers.setAddressLine1(createDTO.getAddressLine1());
        }
        if (createDTO.getAddressLine2() != null) {
            customers.setAddressLine2(createDTO.getAddressLine2());
        }
        if (createDTO.getCity() != null) {
            customers.setCity(createDTO.getCity());
        }
        if (createDTO.getState() != null) {
            customers.setState(createDTO.getState());
        }
        if (createDTO.getPostalCode() != null) {
            customers.setPostalCode(createDTO.getPostalCode());
        }
        if (createDTO.getCountry() != null) {
            customers.setCountry(createDTO.getCountry());
        }
        if (createDTO.getSalesRepEmployeeNumber() != null) {
            Employees employees = employeesRepository.findById(createDTO.getSalesRepEmployeeNumber()).orElseThrow();
            customers.setSalesRepEmployeeNumber(employees);
        }
        if (createDTO.getCreditLimit() != null) {
            customers.setCreditLimit(createDTO.getCreditLimit());
        }
        return customersRepository.saveAndFlush(customers);
    }

    public void deleteCustomers(Integer id) {
        customersRepository.deleteById(id);
    }

    public Page<Customers> getCustomers(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return customersRepository.findAll(paging);
    }
}
