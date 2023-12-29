package ir.manouchehri.finalgamelectronicsproject.controller;

import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestOrderDto;
import ir.manouchehri.finalgamelectronicsproject.dto.response.ResponseOrderDto;
import ir.manouchehri.finalgamelectronicsproject.service.OrderService;
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
    public ResponseOrderDto addOrder(@Valid @RequestBody RequestOrderDto requestOrderDto) {
        return orderService.addOrder(requestOrderDto);
    }

    @PutMapping("/updateOrder/{id}")
    public ResponseOrderDto updateOrder(@PathVariable Long id, @Valid @RequestBody RequestOrderDto requestOrderDto) {
        return orderService.updateOrder(id, requestOrderDto);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/getOrder")
    public ResponseOrderDto getOrder(@RequestParam Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/getAllOrder")
    public List<ResponseOrderDto> getAllOrder() {
        return orderService.getAllOrders();
    }

    @GetMapping("/findOrdersByUserId")
    public List<ResponseOrderDto> findOrdersByUserId(@RequestParam Long id) {
        return orderService.findOrdersByUserId(id);
    }

    @GetMapping("/findOrdersByProductId")
    public List<ResponseOrderDto> findOrdersByProductId(@RequestParam Long id) {
        return orderService.findOrdersByProductId(id);
    }

    @PostMapping("/submitPayOrder")
    public void submitPayOrder(@RequestParam Long id) {
        orderService.submitPayOrder(id);
    }

    @GetMapping("/ordersNotPayYet")
    public List<ResponseOrderDto> ordersNotPayYet() {
        return orderService.ordersNotPayYet();
    }

    @GetMapping("/ordersPay")
    public List<ResponseOrderDto> ordersPay() {
        return orderService.ordersPay();
    }

}
