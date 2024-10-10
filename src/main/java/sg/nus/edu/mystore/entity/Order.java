package sg.nus.edu.mystore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order extends BaseEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public OrderStatus status;
    public enum OrderStatus {
        PENDING, SHIPPED, DELIVERED, CANCELLED};

    //getters and setters
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    private Double total_price;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address shipping_address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    @OneToMany(mappedBy = "order")
    private List<Order_Product> order_product;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Address getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(Address shipping_address) {
        this.shipping_address = shipping_address;
    }

    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = user;
    }

    public List<Order_Product> getOrder_product() {
        return order_product;
    }

    public void setOrder_product(List<Order_Product> order_product) {
        this.order_product = order_product;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total_price=" + total_price +
                ", shipping_address=" + shipping_address +
                ", user=" + users +
                ", order_product=" + order_product +
                ", payment=" + payment +
                '}';
    }
}
