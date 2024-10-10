package sg.nus.edu.mystore.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.nus.edu.mystore.entity.Order;
import sg.nus.edu.mystore.interfacemethods.OrderInterface;
import sg.nus.edu.mystore.entity.Order_Product;
import sg.nus.edu.mystore.repository.OrderRepository;
import sg.nus.edu.mystore.repository.Order_ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderImplementation implements OrderInterface {

    @Autowired
    private final Order_ProductRepository order_ProductRepository;

    public OrderImplementation(Order_ProductRepository orderProductRepository) {
        this.order_ProductRepository = orderProductRepository;
    }

    @Transactional
    @Override
    public void placeOrder(List<Order_Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("No products in the cart");
            return;
        } else {
            order_ProductRepository.saveAll(productList);
        }
        return;
    }

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public void cancelOrder(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            // 检查订单状态是否可以取消
            if (order.getStatus().equals("PENDING")) {
                orderRepository.delete(order);
                System.out.println("Order with ID " + orderId + " has been canceled.");
            } else {
                System.out.println("Order with ID " + orderId + " cannot be canceled, as it's already " + order.getStatus() + ".");
            }
        } else {
            System.out.println("Order with ID " + orderId + " does not exist.");
        }
    }

    @Transactional
    @Override
    public void updateOrderStatus(int orderId, String status) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(Order.OrderStatus.valueOf(status)); // 更新订单状态
            orderRepository.save(order); // 保存更新
            System.out.println("Order with ID " + orderId + " status has been updated to " + status + ".");
        } else {
            System.out.println("Order with ID " + orderId + " does not exist.");
        }
    }

    public List<Order> getOrdersByUsers(Integer users) {
        return orderRepository.findByUser(users);
    }
}
