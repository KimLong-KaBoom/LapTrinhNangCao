import java.util.Scanner;


class Product {
    private String name;
    private double price, discount;
    private int quantity;
    private static double taxRate = 0.1, totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;

    }

    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    public double calculateFinalPrice() {
        return (price - discount) * (1 + taxRate);
    }

    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= quantity) {
            totalRevenue += (amount * calculateFinalPrice());
            quantity -= amount;
            System.out.println("Success");
        }
        else {
            System.err.println("Insufficient stock");
        }
    }

    public static void main(String[] args) {

        Product p1 = new Product("iPhone", 1000, 10, 50);
        Product p2 = new Product("ipad", 2000, 15, 200);
        System.out.println("Nhap so luong mua cho p1, p2");
        Scanner sc = new Scanner(System.in);
        p1.sell(sc.nextInt());
        p2.sell(sc.nextInt());
        

        System.out.println("p1 final price:" + p1.calculateFinalPrice());
        System.out.println("p2 final price:" + p2.calculateFinalPrice());

        updateTaxRate(0.08);
        System.out.println("Updated TaxRate:");
        System.out.println("p1 final price:" + p1.calculateFinalPrice());
        System.out.println("p2 final price:" + p2.calculateFinalPrice());
        
        p1.updateDiscount(10.0);
        System.out.println("Updated Discount:");
        System.out.println("p1 final price:" + p1.calculateFinalPrice());
        System.out.println("p2 final price:" + p2.calculateFinalPrice());

        System.out.println("Total revenue:" + totalRevenue);

    }
}
