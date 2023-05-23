package sit.remidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.remidterm.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
