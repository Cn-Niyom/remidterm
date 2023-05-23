package sit.remidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.remidterm.model.Payments;
import sit.remidterm.utils.PaymentsID;

import java.util.List;

public interface PaymentsRepository extends JpaRepository<Payments, PaymentsID> {
    List<Payments> findByCheckNumber(String checkNumber);

    List<Payments> findByCustomer_CustomerNumber(Integer customerNumber);

    Payments findByCheckNumberAndCustomer_CustomerNumber(String checkNumber, Integer customerNumber);
}
