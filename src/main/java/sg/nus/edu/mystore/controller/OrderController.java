package sg.nus.edu.mystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.nus.edu.mystore.entity.Order;
import sg.nus.edu.mystore.entity.Order_Product;
import sg.nus.edu.mystore.service.OrderImplementation;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderImplementation orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody List<Order_Product> productList) {
        orderService.placeOrder(productList);
        return ResponseEntity.ok("Order has been placed.");
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable int orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("Order cancellation processed.");
    }

    @PutMapping("/updateOrderStatus/{orderId}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int orderId, @RequestParam String status) {
        orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok("Order status has been updated.");
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<Order>> getOrdersByUsers(@PathVariable Integer userId) {
        List<Order> orders = orderService.getOrdersByUsers(userId);
        return ResponseEntity.ok(orders);
    }
}
