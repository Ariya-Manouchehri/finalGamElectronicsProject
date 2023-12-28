package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.Order;
import ir.manouchehri.finalgamelectronicsproject.dto.OrderDto;
import ir.manouchehri.finalgamelectronicsproject.mapper.OrderDtoMapper;
import ir.manouchehri.finalgamelectronicsproject.mapper.ProductDtoMapper;
import ir.manouchehri.finalgamelectronicsproject.mapper.UserDtoMapper;
import ir.manouchehri.finalgamelectronicsproject.repository.OrderRepository;
import ir.manouchehri.finalgamelectronicsproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    OrderDtoMapper orderDtoMapper;
    UserDtoMapper userDtoMapper;
    ProductDtoMapper productDtoMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDtoMapper orderDtoMapper, UserDtoMapper userDtoMapper, ProductDtoMapper productDtoMapper) {
        this.orderRepository = orderRepository;
        this.orderDtoMapper = orderDtoMapper;
        this.userDtoMapper = userDtoMapper;
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = orderRepository.save(orderDtoMapper.orderDtoToOrder(orderDto));
        return orderDtoMapper.orderToOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Optional<Order> order = orderRepository.findById(id);
        order.get().setTotalPrice(orderDto.getTotalPrice());
        order.get().setProducts(productDtoMapper.listOfProductDtoToListOfProduct(orderDto.getProductsDto()));
        order.get().setUser(userDtoMapper.userDtoToUser(orderDto.getUserDto()));
        orderRepository.save(order.get());
        return orderDtoMapper.orderToOrderDto(order.get());
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDto getOrder(Long id) {
        return orderDtoMapper.orderToOrderDto(orderRepository.findById(id).get());
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.findAll());
    }
}
