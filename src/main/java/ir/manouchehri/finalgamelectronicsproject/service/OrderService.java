package ir.manouchehri.finalgamelectronicsproject.service;

import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestOrderDto;
import ir.manouchehri.finalgamelectronicsproject.dto.response.ResponseOrderDto;

import java.util.List;

public interface OrderService {
    ResponseOrderDto addOrder(RequestOrderDto requestOrderDto);

    ResponseOrderDto updateOrder(Long id, RequestOrderDto requestOrderDto);

    void deleteOrder(Long id);

    ResponseOrderDto getOrder(Long id);

    List<ResponseOrderDto> getAllOrders();

    List<ResponseOrderDto> findOrdersByUserId(Long id);

    List<ResponseOrderDto> findOrdersByProductId(Long id);

    void submitPayOrder(Long id);

    List<ResponseOrderDto> ordersNotPayYet();

    List<ResponseOrderDto> ordersPay();
}
