package ir.manouchehri.finalgamelectronicsproject.domain;

import ir.manouchehri.finalgamelectronicsproject.enums.Pay;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment_tbl")
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "payment")
    private List<Order> orders;

    @Column(name = "pay")
    @Enumerated(EnumType.STRING)
    private Pay pay;
}
