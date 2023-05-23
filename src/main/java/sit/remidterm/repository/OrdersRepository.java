package sit.remidterm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sit.remidterm.model.Orders;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Transactional
    void deleteByCustomer_CustomerNumber(Integer customerNumber);

    List<Orders> findByCustomer_CustomerNumber(Integer customerNumber);
}
