package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestOrderDto;
import ir.manouchehri.finalgamelectronicsproject.dto.response.ResponseOrderDto;
import ir.manouchehri.finalgamelectronicsproject.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OrderServiceImplTest {

    private OrderServiceImpl orderService;

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImplTest(OrderServiceImpl orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Test
    void addOrder() {
        List<Long> products = new ArrayList<>(List.of(1L));
        RequestOrderDto requestOrderDto = new RequestOrderDto();
        int sizeOrder = orderRepository.findAll().size();

        requestOrderDto.setUserId(2L);
        requestOrderDto.setProductsId(products);
        orderService.addOrder(requestOrderDto);
        assertEquals(orderRepository.findAll().size(), sizeOrder + 1);
    }

    @Test
    void updateOrder() {
        List<Long> products = new ArrayList<>(List.of(1L));
        RequestOrderDto requestOrderDto = new RequestOrderDto();

        requestOrderDto.setUserId(2L);
        requestOrderDto.setProductsId(products);
        ResponseOrderDto responseOrderDto = orderService.updateOrder(1L, requestOrderDto);
        assertNotNull(responseOrderDto);
    }

    @Test
    void deleteOrder() {
        int sizeOrder = orderRepository.findAll().size();
        orderService.deleteOrder(1L);
        assertEquals(orderRepository.findAll().size(), sizeOrder - 1);
    }

    @Test
    void getOrder() {
        assertEquals(orderService.getOrder(5L),"سفارش مورد نظر یافت نشد");
    }
}