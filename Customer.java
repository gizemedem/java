public class Customer extends BaseEntitiy{
        private String name;
        private String email;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public static Customer addCustomer(String name, String email) {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            return customer;
        }

        public String getCustomerInfo() {
            return "Customer name=" + this.getName() + ", email=" + this.getEmail() ;
        }
    }
}
