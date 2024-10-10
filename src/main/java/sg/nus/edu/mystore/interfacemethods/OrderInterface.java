package sg.nus.edu.mystore.interfacemethods;

import sg.nus.edu.mystore.entity.Order_Product;

import java.util.List;

public interface OrderInterface{

    public void placeOrder(List<Order_Product> productList);
    public void cancelOrder(int orderId);
    public void updateOrderStatus(int orderId, String status);

}
