package sit.remidterm.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.dto.PaymentCreateDTO;
import sit.remidterm.dto.PaymentDTO;
import sit.remidterm.service.PaymentsService;
import sit.remidterm.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
//    public List<Payments> getPayments() {
//        return paymentsService.getPayments();
//    }
    public List<PaymentDTO> getPayments() {
        return listMapper.mapList(paymentsService.getPayments(), PaymentDTO.class, modelMapper);
    }

    @GetMapping("/checkNumber/{checkNumber}")
//    public List<Payments> getPaymentsBycheckNumber(@PathVariable String checkNumber) {
//        return paymentsService.getPaymentsBycheckNumber(checkNumber);
//    }
    public List<PaymentDTO> getPaymentsBycheckNumber(@PathVariable String checkNumber) {
        return listMapper.mapList(paymentsService.getPaymentsBycheckNumber(checkNumber), PaymentDTO.class, modelMapper);
    }

    @GetMapping("/customerNumber/{customerNumber}")
//    public List<Payments> getPaymentsBycustomerNumber(@PathVariable Integer customerNumber) {
//        return paymentsService.getPaymentsBycustomerNumber(customerNumber);
//    }
    public List<PaymentDTO> getPaymentsBycustomerNumber(@PathVariable Integer customerNumber) {
        return listMapper.mapList(paymentsService.getPaymentsBycustomerNumber(customerNumber), PaymentDTO.class, modelMapper);
    }

    @GetMapping("/{customerNumber}/{checkNumber}")
//    public Payments getPaymentsBycheckNumberAndcustomerNumber(@PathVariable String checkNumber, @PathVariable Integer customerNumber) {
//        return paymentsService.getPaymentsBycheckNumberAndcustomerNumber(checkNumber, customerNumber);
//    }
    public PaymentDTO getPaymentsBycheckNumberAndcustomerNumber(@PathVariable String checkNumber, @PathVariable Integer customerNumber) {
        return modelMapper.map(paymentsService.getPaymentsBycheckNumberAndcustomerNumber(checkNumber, customerNumber), PaymentDTO.class);
    }

    @PostMapping("")
//    public Payments addPayments(@RequestBody PaymentCreateDTO payments) {
//        return paymentsService.addPayments(payments);
//    }
    public PaymentDTO addPayments(@RequestBody PaymentCreateDTO payments) {
        return modelMapper.map(paymentsService.addPayments(payments), PaymentDTO.class);
    }

    @PutMapping("/{customerNumber}/{checkNumber}")
//    public Payments updatePayments(@PathVariable String checkNumber, @PathVariable Integer customerNumber, @RequestBody PaymentCreateDTO payments) {
//        return paymentsService.updatePayments(checkNumber, customerNumber, payments);
//    }
    public PaymentDTO updatePayments(@PathVariable String checkNumber, @PathVariable Integer customerNumber, @RequestBody PaymentCreateDTO payments) {
        return modelMapper.map(paymentsService.updatePayments(checkNumber, customerNumber, payments), PaymentDTO.class);
    }

    @DeleteMapping("/{customerNumber}/{checkNumber}")
//    public void deletePayments(@PathVariable String checkNumber, @PathVariable Integer customerNumber) {
//        paymentsService.deletePayments(checkNumber, customerNumber);
//    }
    public void deletePayments(@PathVariable String checkNumber, @PathVariable Integer customerNumber) {
        paymentsService.deletePayments(checkNumber, customerNumber);
    }

}
