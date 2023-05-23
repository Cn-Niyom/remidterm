package sit.remidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.remidterm.model.Productlines;

public interface ProductlinesRepository extends JpaRepository<Productlines, String> {

}
