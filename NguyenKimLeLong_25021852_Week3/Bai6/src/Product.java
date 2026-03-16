import java.util.Scanner;
import java.time.LocalDate;

abstract public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    double getFinalPrice() {
        return price;
    }
    abstract String getType();

    String getName() {
        return name;
    }
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Product[] products = new Product[n];
        for (int i = 0; i < n; ++i) {
            String line = sc.nextLine();

            char type = line.charAt(0);

            int firstQuote = line.indexOf('"');
            int secondQuote = line.indexOf('"', firstQuote + 1);

            String name = line.substring(firstQuote + 1, secondQuote);
            String rest = line.substring(secondQuote + 2);
            String[] nums = rest.split(" ");

            if(type == 'E') {
                double price = Double.parseDouble(nums[0]);
                double warrantyFees = Double.parseDouble(nums[1]);
                products[i] = new Electronics(name, price, warrantyFees);
            }
            else {
                
                double price = Double.parseDouble(nums[0]);
                LocalDate expiryDate = LocalDate.parse(nums[1]);
                products[i] = new Food(name, price, expiryDate);
            }
        }

        for (Product i : products) {
            System.out.println(i.getName() + " - " + i.getType() + " - " + i.getFinalPrice());
        }

        Order order = new Order(products);

        System.out.println(order.getTotal());
    }
}

class Order {
    private Product[] products;

    public Order(Product[] products) {
        this.products = products;
    }

    public double getTotal() {

        double sum = 0;

        for (Product p : products) {
            sum += p.getFinalPrice();
        }

        return sum;
    }
}