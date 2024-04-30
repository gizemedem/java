import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity {
    private Long customerId;
    private List<Order> orders;
    private List<Product> products;
    private double totalPrice;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        if (this.orders == null) {
            this.orders = new ArrayList<>();
        }
        this.orders.add(order);
    }

    public static Cart getCart(Long customerId) {
        return null;
    }

    public void addProductToCart(Product product) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        this.products.add(product);
    }


    public void removeProductFromCart(Product product) {
        if (this.products != null) {
            this.products.remove(product);
        }
    }

    public void updateCart(List<Order> orders) {
        this.orders = orders;
    }


    public void emptyCart() {
        this.orders = new ArrayList<>();
    }

    private void calculateTotalPrice() {
        double totalPrice = 0.0;
        if (this.products != null) {
            for (Product product : this.products) {
                totalPrice += product.getPrice();
            }
        }
        this.setTotalPrice(totalPrice);
    }