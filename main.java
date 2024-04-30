class Product {
    private String productId;
    private String name;
    private double price;
    private int stock;

    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
class OrderDetail {
    private Product product;
    private double price;
    private int quantity;

    public OrderDetail(Product product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Cart {
    private Map<String, OrderDetail> cartItems;
    private double totalPrice;

    public Cart() {
        this.cartItems = new HashMap<>();
        this.totalPrice = 0.0;
    }

    public void addProductToCart(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            if (cartItems.containsKey(product.getProductId())) {
                OrderDetail orderDetail = cartItems.get(product.getProductId());
                orderDetail.setQuantity(orderDetail.getQuantity() + quantity);
            } else {
                OrderDetail orderDetail = new OrderDetail(product, product.getPrice(), quantity);
                cartItems.put(product.getProductId(), orderDetail);
            }
            product.setStock(product.getStock() - quantity);
            calculateTotalPrice();
        } else {
            System.out.println("Üzgünüz, stokta yeterli ürün bulunmamaktadır.");
        }
    }

    public void removeProductFromCart(Product product, int quantity) {
        if (cartItems.containsKey(product.getProductId())) {
            OrderDetail orderDetail = cartItems.get(product.getProductId());
            int remainingQuantity = orderDetail.getQuantity() - quantity;
            if (remainingQuantity <= 0) {
                cartItems.remove(product.getProductId());
            } else {
                orderDetail.setQuantity(remainingQuantity);
            }
            product.setStock(product.getStock() + quantity);
            calculateTotalPrice();
        }
    }

    public void emptyCart() {
        cartItems.clear();
        totalPrice = 0.0;
    }

    public void printCartItems() {
        System.out.println("Sepetteki Ürünler:");
        for (Map.Entry<String, OrderDetail> entry : cartItems.entrySet()) {
            OrderDetail orderDetail = entry.getValue();
            Product product = orderDetail.getProduct();
            System.out.println("Ürün ID: " + product.getProductId() + ", Ürün Adı: " + product.getName() +
                    ", Fiyatı: " + orderDetail.getPrice() + ", Miktarı: " + orderDetail.getQuantity());
        }
        System.out.println("Toplam Fiyat: " + totalPrice);
    }

    private void calculateTotalPrice() {
        double totalPrice = 0.0;
        for (OrderDetail orderDetail : cartItems.values()) {
            totalPrice += orderDetail.getPrice() * orderDetail.getQuantity();
        }
        this.totalPrice = totalPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("P001", "Laptop", 3000.0, 10);
        Product product2 = new Product("P002", "Telefon", 2000.0, 15);

        Cart cart = new Cart();

        cart.addProductToCart(product1, 2);
        cart.addProductToCart(product2, 1);

        cart.printCartItems();

        cart.removeProductFromCart(product1, 1);

        cart.printCartItems();
    }
}
