package ir.manouchehri.finalgamelectronicsproject.repository;

import ir.manouchehri.finalgamelectronicsproject.domain.Order;
import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.response.ResponseOrderDto;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("select or from Order or where or.user.id = :id")
    List<Order> findOrdersByUserId(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select * from order_tbl where id = (select order_id from order_product_tbl where product_id = :id)")
    List<Order> findOrdersByProductId(@Param("id") Long id);

    @Query(nativeQuery = true ,value = "update order_tbl set pay = 'Yes' where id = :id")
    void submitPayOrder(@Param("id") Long id);

    @Query("select or from Order or where or.pay = 'No'")
    List<Order> ordersNotPayYet();

    @Query("select or from Order or where or.pay = 'Yes'")
    List<Order> ordersPay();
}
