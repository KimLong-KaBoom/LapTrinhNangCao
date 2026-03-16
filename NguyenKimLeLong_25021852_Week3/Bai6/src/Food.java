import java.time.LocalDate;


public class Food extends Product {
    LocalDate expiryDate;

    Food(String name, double price, LocalDate expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    double getFinalPrice() {
        LocalDate today = LocalDate.now();
        if (expiryDate.isBefore(today.plusDays(7))) {
            return price * 0.8;
        }
        return price;
    }

    String getType() {
        return "Food";
    }
}