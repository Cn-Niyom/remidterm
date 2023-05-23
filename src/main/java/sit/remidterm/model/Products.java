package sit.remidterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @Column(name = "productCode", nullable = false)
    private String productCode;
    @Column(name = "productName", nullable = false)
    private String productName;
    @ManyToOne
    @JoinColumn(name = "productLine", nullable = false)
    private Productlines productLine;
    @Column(name = "productScale", nullable = false)
    private String productScale;
    @Column(name = "productVendor", nullable = false)
    private String productVendor;
    @Column(name = "productDescription", nullable = false)
    private String productDescription;
    @Column(name = "quantityInStock", nullable = false)
    private Integer quantityInStock;
    @Column(name = "buyPrice", nullable = false)
    private Double buyPrice;
    @Column(name = "MSRP", nullable = false)
    private Double retailPrice;
}
