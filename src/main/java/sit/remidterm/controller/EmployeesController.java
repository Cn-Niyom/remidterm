package sit.remidterm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.dto.EmployeeCreateDTO;
import sit.remidterm.dto.EmployeeDTO;
import sit.remidterm.service.EmployeesService;
import sit.remidterm.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public List<EmployeeDTO> getEmployees() {
        return listMapper.mapList(employeesService.getEmployees(), EmployeeDTO.class, modelMapper);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployees(@PathVariable Integer id) {
        return modelMapper.map(employeesService.getEmployees(id), EmployeeDTO.class);
    }

    @PostMapping("")
    public EmployeeDTO createEmployees(EmployeeCreateDTO employees) {
        return modelMapper.map(employeesService.createEmployees(employees), EmployeeDTO.class);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployees(@PathVariable Integer id, EmployeeCreateDTO employees) {
        return modelMapper.map(employeesService.updateEmployess(id, employees), EmployeeDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployees(@PathVariable Integer id) {
        employeesService.deleteEmployees(id);
    }

}
