package sit.remidterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.remidterm.utils.PaymentsID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
@IdClass(PaymentsID.class)
public class Payments {
    @Id
    @ManyToOne
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customers customer;
    @Id
    @Column(name = "checkNumber", nullable = false, length = 50)
    private String checkNumber;
    @Column(name = "paymentDate", nullable = false)
    private String paymentDate;
    @Column(name = "amount", nullable = false)
    private Double amount;
}
