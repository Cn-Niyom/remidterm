package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.remidterm.dto.EmployeeCreateDTO;
import sit.remidterm.model.Employees;
import sit.remidterm.repository.EmployeesRepository;
import sit.remidterm.repository.OfficesRepository;

import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private OfficesRepository officesRepository;

    public List<Employees> getEmployees() {
        return employeesRepository.findAll();
    }

    public Employees getEmployees(Integer employeeNumber) {
        return employeesRepository.findById(employeeNumber).orElseThrow();
    }

    public Employees createEmployees(EmployeeCreateDTO employees) {
        Employees employees1 = new Employees();
        return getEmployees(employees, employees1);
    }

    public Employees updateEmployess(Integer employessNumber, EmployeeCreateDTO employeeCreateDTO) {
        Employees employees = employeesRepository.findById(employessNumber).orElseThrow();
        return getEmployees(employeeCreateDTO, employees);
    }

    private Employees getEmployees(EmployeeCreateDTO employeeCreateDTO, Employees employees) {
        if (employeeCreateDTO.getEmployeeNumber() != null) {
            employees.setEmployeeNumber(employeeCreateDTO.getEmployeeNumber());
        }
        if (employeeCreateDTO.getLastName() != null) {
            employees.setLastName(employeeCreateDTO.getLastName());
        }
        if (employeeCreateDTO.getFirstName() != null) {
            employees.setFirstName(employeeCreateDTO.getFirstName());
        }
        if (employeeCreateDTO.getExtension() != null) {
            employees.setExtension(employeeCreateDTO.getExtension());
        }
        if (employeeCreateDTO.getEmail() != null) {
            employees.setEmail(employeeCreateDTO.getEmail());
        }
        if (employeeCreateDTO.getOfficeCode() != null) {
            employees.setOfficeCode(officesRepository.findById(employeeCreateDTO.getOfficeCode()).orElseThrow());
        }
        if (employeeCreateDTO.getReportsTo() != null) {
            Employees employees2 = employeesRepository.findById(employeeCreateDTO.getReportsTo()).orElseThrow();
            employees.setReportsTo(employees2);
        }
        if (employeeCreateDTO.getJobTitle() != null) {
            employees.setJobTitle(employeeCreateDTO.getJobTitle());
        }
        return employeesRepository.saveAndFlush(employees);
    }

    public void deleteEmployees(Integer employeeNumber) {
        employeesRepository.deleteById(employeeNumber);
    }

}
