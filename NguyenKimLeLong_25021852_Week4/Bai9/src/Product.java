abstract class Product {
    String id;
    String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void display();
}