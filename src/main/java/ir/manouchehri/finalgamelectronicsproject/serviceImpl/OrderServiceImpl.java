package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.Order;
import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestOrderDto;
import ir.manouchehri.finalgamelectronicsproject.dto.response.ResponseOrderDto;
import ir.manouchehri.finalgamelectronicsproject.mapper.OrderDtoMapper;
import ir.manouchehri.finalgamelectronicsproject.repository.OrderRepository;
import ir.manouchehri.finalgamelectronicsproject.repository.ProductRepository;
import ir.manouchehri.finalgamelectronicsproject.repository.UserRepository;
import ir.manouchehri.finalgamelectronicsproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    UserRepository userRepository;
    ProductRepository productRepository;
    OrderDtoMapper orderDtoMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, OrderDtoMapper orderDtoMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderDtoMapper = orderDtoMapper;
    }

    @Override
    public ResponseOrderDto addOrder(RequestOrderDto requestOrderDto) {
        List<Product> products = productRepository.findAllById(requestOrderDto.getProductsId());
        User user = userRepository.getUser(requestOrderDto.getUserId());
        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        Double totalPrice = 0d;
        for (Product item : products) {
            totalPrice += item.getPrice();
        }
        order.setTotalPrice(totalPrice);
        return orderDtoMapper.orderToOrderDto(orderRepository.save(order));
    }

    @Override
    public ResponseOrderDto updateOrder(Long id, RequestOrderDto requestOrderDto) {
        Optional<Order> order = orderRepository.findById(id);
        List<Product> products = productRepository.findAllById(requestOrderDto.getProductsId());
        User user = userRepository.getUser(requestOrderDto.getUserId());
        ;
        order.get().setUser(user);
        order.get().setProducts(products);
        Double totalPrice = 0d;
        for (Product item : products) {
            totalPrice += item.getPrice();
        }
        order.get().setTotalPrice(totalPrice);
        return orderDtoMapper.orderToOrderDto(orderRepository.save(order.get()));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public ResponseOrderDto getOrder(Long id) {
        return orderDtoMapper.orderToOrderDto(orderRepository.findById(id).get());
    }

    @Override
    public List<ResponseOrderDto> getAllOrders() {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.findAll());
    }

    @Override
    public List<ResponseOrderDto> findOrdersByUserId(Long id) {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.findOrdersByUserId(id));
    }

    @Override
    public List<ResponseOrderDto> findOrdersByProductId(Long id) {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.findOrdersByProductId(id));
    }

    @Override
    public void submitPayOrder(Long id) {
        orderRepository.submitPayOrder(id);
    }

    @Override
    public List<ResponseOrderDto> ordersNotPayYet() {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.ordersNotPayYet());
    }

    @Override
    public List<ResponseOrderDto> ordersPay() {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.ordersPay());
    }
}
