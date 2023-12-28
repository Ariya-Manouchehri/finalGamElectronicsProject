package ir.manouchehri.finalgamelectronicsproject.controller;

import ir.manouchehri.finalgamelectronicsproject.dto.OrderDto;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.service.OrderService;
import ir.manouchehri.finalgamelectronicsproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public OrderDto addOrder(@Valid @RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }
    
    @PutMapping("/updateOrder/{id}")
    public OrderDto updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDto orderDto){
        return orderService.updateOrder(id,orderDto);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

    @GetMapping("/getOrder")
    public OrderDto getOrder(@RequestParam Long id){
        return orderService.getOrder(id);
    }

    @GetMapping("/getAllOrder")
    public List<OrderDto> getAllOrder(){
        return orderService.getAllOrders();
    }
}
