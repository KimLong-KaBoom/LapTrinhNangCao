public class Main {
    public static void main(String[] args) {
    Product[] arr = new Product[10];
    arr[0] = new Product("1", "Laptop", 1000);
    arr[1] = new Product("2", "Iphone", 570);
    
    Inventory kho = new Inventory(arr);
    arr[0].setPrice(5000);

    System.out.println(kho.items[0].id + " " + kho.items[0].name + " " + kho.items[0].price + "$");
    System.out.println(kho.items[1].id + " " + kho.items[1].name + " " + kho.items[1].price + "$");
    }
}

class Product {
    public String id, name;
    public double price;
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setPrice(double x) {
        this.price = x;
    }
    
}

class Inventory {
    public Product[] items;
    public Inventory(Product[] initialItemls) {
        items = initialItemls;
    }

}