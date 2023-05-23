package sit.remidterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.remidterm.utils.OrderdetailsID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetails")
@IdClass(OrderdetailsID.class)
public class Orderdetails {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderNumber", nullable = false)
    private Orders order;
    @Id
    @ManyToOne
    @JoinColumn(name = "productCode",referencedColumnName = "productCode", nullable = false)
    private Products product;
    @Column(name = "quantityOrdered", nullable = false)
    private Integer quantityOrdered;
    @Column(name = "priceEach", nullable = false)
    private Double priceEach;
    @Column(name = "orderLineNumber", nullable = false)
    private Integer orderLineNumber;

}
