package ir.manouchehri.finalgamelectronicsproject.domain;

import ir.manouchehri.finalgamelectronicsproject.enums.Pay;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_tbl")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToMany
    @JoinTable(name = "order_product_tbl", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column(name = "pay")
    @Enumerated(EnumType.STRING)
    private Pay pay;
}