public class Electronics extends Product {

    double warrantyFees;

    Electronics(String name, double price, double warrantyFees) {
        super(name, price);
        this.warrantyFees = warrantyFees;
    }
    @Override
    double getFinalPrice() {
        return price * 1.1 + warrantyFees;
    }

    String getType() {
        return "Electronics";
    }
}
