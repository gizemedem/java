public class Order extends BaseEntitiy{
    private String orderId;
    private Long customerId;

    public String getOrderId() {
        return orderCode;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public static Order placeOrder(String orderId, Long customerId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCustomerId(customerId);
        return order;
    }

    public static Order getOrderForCode(String orderCode) {
        return null;
    }

    public static List<Order> getAllOrdersForCustomer(Long customerId) {
        return null;
    }

    public String getOrderInfo() {
        return "Order orderCode=" + this.getOrderCode() + ", customerId=" + this.getCustomerId();
    }
}
}
