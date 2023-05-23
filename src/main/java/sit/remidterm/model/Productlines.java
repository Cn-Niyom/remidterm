package sit.remidterm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productlines")
public class Productlines {
    @Id
    @Column(name = "productLine", nullable = false)
    private String productLine;
    @Column(name = "textDescription")
    private String textDescription;
}
