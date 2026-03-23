import java.time.LocalDate;

class food extends Product {
    LocalDate expiryDate;

    public food(String id, String name, LocalDate expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void display() {
        System.out.println(name + " - " + expiryDate.toString());
    }
}