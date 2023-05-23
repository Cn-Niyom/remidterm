package sit.remidterm.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "orderNumber", nullable = false)
    private Integer orderNumber;
    @Column(name = "orderDate", nullable = false)
    private Date orderDate;
    @Column(name = "requiredDate", nullable = false)
    private Date requiredDate;
    @Column(name = "shippedDate")
    private Date shippedDate;
    @Column(name = "status", nullable = false, length = 15)
    private String status;
    @Column(name = "comments", length = 65535)
    private String comments;
    @ManyToOne
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customers customer;
}