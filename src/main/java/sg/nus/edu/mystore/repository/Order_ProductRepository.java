package sg.nus.edu.mystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.nus.edu.mystore.entity.Order_Product;

public interface Order_ProductRepository extends JpaRepository<Order_Product, Long> {
}
