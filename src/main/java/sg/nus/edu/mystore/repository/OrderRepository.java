package sg.nus.edu.mystore.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sg.nus.edu.mystore.entity.Order;
import sg.nus.edu.mystore.entity.Order.OrderStatus;
import sg.nus.edu.mystore.entity.User;

import java.util.List;


@Repository

public interface OrderRepository<Order> extends JpaRepository<Order, Integer> {

    List<Order> findByStatus(OrderStatus status);
    List<Order> findByUser(int users);
}