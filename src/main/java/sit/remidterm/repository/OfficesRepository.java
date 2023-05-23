package sit.remidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.remidterm.model.Offices;


public interface OfficesRepository extends JpaRepository<Offices, String> {

}
