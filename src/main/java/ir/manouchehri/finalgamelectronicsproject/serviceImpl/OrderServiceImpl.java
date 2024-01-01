package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.Order;
import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestOrderDto;
import ir.manouchehri.finalgamelectronicsproject.dto.response.ResponseOrderDto;
import ir.manouchehri.finalgamelectronicsproject.enums.Pay;
import ir.manouchehri.finalgamelectronicsproject.exceptions.OrderException.*;
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
        try {
            List<Product> products = productRepository.findAllById(requestOrderDto.getProductsId());
            if (products.isEmpty()) {
                throw new AddOrderException();
            }
            User user = userRepository.getUser(requestOrderDto.getUserId());
            if (user == null) {
                throw new AddOrderException();
            }
            Order order = new Order();
            order.setUser(user);
            order.setProducts(products);
            Double totalPrice = 0d;
            for (Product item : products) {
                totalPrice += item.getPrice();
            }
            order.setTotalPrice(totalPrice);
            order.setPay(Pay.No);
            return orderDtoMapper.orderToOrderDto(orderRepository.save(order));
        } catch (Exception e) {
            throw new AddOrderException();
        }

    }

    @Override
    public ResponseOrderDto updateOrder(Long id, RequestOrderDto requestOrderDto) {
        try {
            Optional<Order> order = orderRepository.findById(id);
            List<Product> products = productRepository.findAllById(requestOrderDto.getProductsId());
            if (products.isEmpty()) {
                throw new UpdateOrderException();
            }
            User user = userRepository.getUser(requestOrderDto.getUserId());
            if (user == null) {
                throw new UpdateOrderException();
            }
            order.get().setUser(user);
            order.get().setProducts(products);
            Double totalPrice = 0d;
            for (Product item : products) {
                totalPrice += item.getPrice();
            }
            order.get().setTotalPrice(totalPrice);
            order.get().setPay(Pay.No);
            return orderDtoMapper.orderToOrderDto(orderRepository.save(order.get()));
        } catch (Exception e) {
            throw new UpdateOrderException();
        }
    }

    @Override
    public void deleteOrder(Long id) {
        try {
            Optional<Order> order = orderRepository.findById(id);
            if (order.isEmpty()) {
                throw new DeleteOrderException();
            }
            orderRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteOrderException();
        }

    }

    @Override
    public ResponseOrderDto getOrder(Long id) {
        try {
            Optional<Order> order = orderRepository.findById(id);
            if (order.isEmpty()) {
                throw new FindOrderException();
            }
            return orderDtoMapper.orderToOrderDto(order.get());
        } catch (Exception e) {
            throw new FindOrderException();
        }
    }

    @Override
    public List<ResponseOrderDto> getAllOrders() {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.findAll());
    }

    @Override
    public List<ResponseOrderDto> findOrdersByUserId(Long id) {
        try {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.findOrdersByUserId(id));
        }catch (Exception e){
            throw new FindOrderByUserIdException();
        }
    }

    @Override
    public List<ResponseOrderDto> findOrdersByProductId(Long id) {
        try {
        return orderDtoMapper.listOfOrderToListOfOrderDto(orderRepository.findOrdersByProductId(id));
        }catch (Exception e){
            throw new FindOrderByProductIdException();
        }
    }

    @Override
    public void submitPayOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        order.get().setPay(Pay.Yes);
        orderRepository.save(order.get());
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
