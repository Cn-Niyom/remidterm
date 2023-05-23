package sit.remidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.remidterm.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
