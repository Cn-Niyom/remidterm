package sit.remidterm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.model.Offices;
import sit.remidterm.service.OfficesService;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficesController {
    @Autowired
    private OfficesService officesService;

    @GetMapping("")
    public List<Offices> getOffices() {
        return officesService.getOffices();
    }

    @GetMapping("/{id}")
    public Offices getOfficesByOfficeCode(@PathVariable String id) {
        return officesService.getOffices(id);
    }

    @GetMapping("/pages")
    public List<Offices> getOffices(@RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    @RequestParam(defaultValue = "officeCode") String sort,
                                    @RequestParam(defaultValue = "ASC") String sortDirection) {

        return officesService.getOffices(page, size, sort, sortDirection);
    }

    @PostMapping("")
    public Offices addOffices(@RequestBody Offices offices) {

        return officesService.addOffices(offices);
    }

    @PutMapping("{id}")
    public Offices updateOffices(@PathVariable String id, @RequestBody Offices offices) {
        return officesService.updateOffices(id, offices);
    }

    @DeleteMapping("/{id}")
    public void deleteOfficesById(@PathVariable String id) {
        officesService.deleteOfficesById(id);
    }


}
