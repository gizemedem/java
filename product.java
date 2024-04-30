public class Product extends BaseEntitiy{
    private String name;
    private double price;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price=price;
    }

     public static Product CreateProduct(String name, double price){
        Product product= new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
     }

     public void UpdateProduct(String name, double price){
        this.setName(name);
        this.setPrice(price);
     }

     public void DeleteProduct(){

     }
      public String GetProduct(){
        return "Product name="+this.getName()+",price="+this.getPrice();
      }

}
