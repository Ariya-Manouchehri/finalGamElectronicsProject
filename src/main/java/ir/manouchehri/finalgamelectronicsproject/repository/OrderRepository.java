package ir.manouchehri.finalgamelectronicsproject.repository;

import ir.manouchehri.finalgamelectronicsproject.domain.Order;
import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
