import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Employee[] employees = new Employee[n];
        long totalSalary = 0;
        for (int i = 0; i < n; ++i) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double baseSalary = sc.nextDouble();
            if (type.equals("O")) {
                employees[i] = new OfficeWorker(id, name, baseSalary);
            }
            else {
                int overtimeHours = sc.nextInt();
                employees[i] = new Technicion(id, name, baseSalary, overtimeHours);
            }
            double pay = employees[i].calculatePay();
            totalSalary += pay;
            System.out.println(employees[i].name + " - Pay: " + pay);

            employees[i].work();
            System.out.print('\n');
        } 
        
        System.out.println("Total salary: " + totalSalary);
    }
}
