import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Store<food> foodStore = new Store<>();
        Store<electronic> electronicStore = new Store<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            if (type.equals("F")) {
                String id = sc.next();
                String name = sc.next();
                LocalDate date = LocalDate.parse(sc.next());

                foodStore.add(new food(id, name, date));

            } else if (type.equals("E")) {
                String id = sc.next();
                String name = sc.next();
                int warranty = sc.nextInt();

                electronicStore.add(new electronic(id, name, warranty));
            }
        }

        System.out.println("Kho Thực phẩm:");
        foodStore.displayAll();
        System.out.println();
        System.out.println("Kho Điện tử:");
        electronicStore.displayAll();
    }
}