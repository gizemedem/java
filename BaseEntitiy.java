public abstract class BaseEntitiy {
    public class Main {
        public static void main(String[] args) {
            Product product = new Product();
            product.setName("Telefon");
            product.setPrice(2000.0);

            Customer customer = new Customer();

            Order order = new Order();
            order.setProduct(product);
            order.setCustomer(customer);

            Cart cart = new Cart();
            cart.addProduct(product);
            cart.setCustomer(customer);

            System.out.println("Ürün Adı: " + order.getProduct().getName());
            System.out.println("Müşteri ID: " + order.getCustomer().getId());
            System.out.println("Sepetteki Ürünler: " + cart.getProducts());
            System.out.println("Sepetteki Müşteri ID: " + cart.getCustomer().getId());
        }
    }
}
