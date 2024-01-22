package ir.manouchehri.finalgamelectronicsproject.repository;

import ir.manouchehri.finalgamelectronicsproject.domain.Order;
import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.enums.Pay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    User user;
    Product product;
    Order order;

    @BeforeEach
    void setup() {
        user = new User();
        user.setId(1L);
        user.setMobilePhone("09215960799");
        user.setPassword("Ariya123456");
        userRepository.save(user);

        product = new Product();
        product.setId(1L);
        product.setPrice(23.500);
        product.setName("pofak");
        productRepository.save(product);

        order = new Order();
        order.setId(1L);
        order.setUser(user);
        order.setProducts(List.of(product));
        order.setTotalPrice(330.00);
        order.setPay(Pay.No);
    }

    @Test
    void findOrdersByUserId() {
        //given
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        orderRepository.saveAll(orders);

        //when
        List<Order> expect = orderRepository.findOrdersByUserId(user.getId());

        //then
        Assertions.assertArrayEquals(orders.toArray(), expect.toArray());
    }

    @Test
    void findOrdersByProductId() {
        //given
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        orderRepository.saveAll(orders);

        //when
        List<Order> expect = orderRepository.findOrdersByProductId(product.getId());

        //then
        Assertions.assertArrayEquals(orders.toArray(), expect.toArray());
    }

    @Test
    void ordersNotPayYet() {
        //given
        orderRepository.save(order);

        //when
        List<Order> expect = orderRepository.ordersNotPayYet();

        //then
        Assertions.assertNotNull(expect);
        Assertions.assertEquals(1,expect.size());
    }
}