import java.util.Scanner;

abstract class Staff implements IPayable {

    protected String id;
    protected String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        IPayable[] payableList = new IPayable[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            if (type.equals("S")) {

                String id = sc.next();
                String name = sc.next();
                int hours = sc.nextInt();
                double rate = sc.nextDouble();

                payableList[i] = new PartTimeStaff(id, name, hours, rate);

            } else if (type.equals("I")) {

                String itemName = sc.next();
                int quantity = sc.nextInt();
                double price = sc.nextDouble();

                payableList[i] = new Invoice(itemName, quantity, price);
            }
        }

        double total = 0;

        for (IPayable p : payableList) {

            double payment = p.getPaymentAmount();
            total += payment;

            if (p instanceof PartTimeStaff) {
                PartTimeStaff s = (PartTimeStaff) p;
                System.out.println("PartTimeStaff " + s.getName() + " - Payment: " + payment);
            }

            else if (p instanceof Invoice) {
                Invoice inv = (Invoice) p;
                System.out.println("Invoice " + inv.getItemName() + " - Payment: " + payment);
            }
        }

        System.out.println("Total Payment = " + total);
    }
}

interface IPayable {
    double getPaymentAmount();
}
