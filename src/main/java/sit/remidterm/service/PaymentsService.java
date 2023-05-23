package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.remidterm.dto.PaymentCreateDTO;
import sit.remidterm.model.Customers;
import sit.remidterm.model.Payments;
import sit.remidterm.repository.CustomersRepository;
import sit.remidterm.repository.PaymentsRepository;

import java.util.List;

@Service
public class PaymentsService {
    @Autowired
    private PaymentsRepository paymentsRepository;
    @Autowired
    private CustomersRepository customersRepository;

    public List<Payments> getPayments() {
        return paymentsRepository.findAll();
    }

    public List<Payments> getPaymentsBycheckNumber(String checkNumber) {
        return paymentsRepository.findByCheckNumber(checkNumber);
    }

    public List<Payments> getPaymentsBycustomerNumber(Integer customerNumber) {
        return paymentsRepository.findByCustomer_CustomerNumber(customerNumber);
    }

    public Payments addPayments(PaymentCreateDTO payments) {
        Payments payments1 = new Payments();
        return getPayments(payments, payments1);
    }

    public Payments getPaymentsBycheckNumberAndcustomerNumber(String checkNumber, Integer customerNumber) {
        return paymentsRepository.findByCheckNumberAndCustomer_CustomerNumber(checkNumber, customerNumber);
    }

    private Payments getPayments(PaymentCreateDTO payments, Payments payments1) {

        if (payments.getCheckNumber() != null) {
            payments1.setCheckNumber(payments.getCheckNumber());
        }
        if (payments.getPaymentDate() != null) {
            payments1.setPaymentDate(payments.getPaymentDate());
        }
        if (payments.getAmount() != null) {
            payments1.setAmount(payments.getAmount());
        }
        if (payments.getCustomerNumber() != null) {
            Customers customers = customersRepository.findById(payments.getCustomerNumber()).orElseThrow();
            payments1.setCustomer(customers);
        }
        return paymentsRepository.saveAndFlush(payments1);
    }

    public Payments updatePayments(String checkNumber, Integer customerNumber, PaymentCreateDTO payments) {
        Payments payments1 = paymentsRepository.findByCheckNumberAndCustomer_CustomerNumber(checkNumber, customerNumber);
        return getPayments(payments, payments1);
    }

    public void deletePayments(String checkNumber, Integer customerNumber) {
        Payments payments = paymentsRepository.findByCheckNumberAndCustomer_CustomerNumber(checkNumber, customerNumber);
        paymentsRepository.delete(payments);
    }
}

