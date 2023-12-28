package ir.manouchehri.finalgamelectronicsproject.service;

import ir.manouchehri.finalgamelectronicsproject.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto addOrder(OrderDto orderDto);

    OrderDto updateOrder(Long id, OrderDto orderDto);

    void deleteOrder(Long id);

    OrderDto getOrder(Long id);

    List<OrderDto> getAllOrders();
}
