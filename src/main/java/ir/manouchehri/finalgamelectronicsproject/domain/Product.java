package ir.manouchehri.finalgamelectronicsproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_tbl")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
