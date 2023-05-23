package sit.remidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.remidterm.model.Products;

public interface ProductsRepository extends JpaRepository<Products, String> {
}
