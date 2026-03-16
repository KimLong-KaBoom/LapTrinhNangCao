import java.util.Scanner;

class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.1;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Employee[] list = new Employee[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            if (type.equals("E")) {

                String name = sc.next();
                double salary = sc.nextDouble();

                list[i] = new Employee(name, salary);
            }

            else if (type.equals("D")) {

                String name = sc.next();
                double salary = sc.nextDouble();
                int overtime = sc.nextInt();

                list[i] = new Developer(name, salary, overtime);
            }

            else if (type.equals("T")) {

                String name = sc.next();
                double salary = sc.nextDouble();
                int bugs = sc.nextInt();

                list[i] = new Tester(name, salary, bugs);
            }
        }

        for (Employee e : list) {

            double bonus = e.calculateBonus();

            System.out.println(e.getName() + " - Bonus: " + bonus);

            if (e instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            }
            else if (e instanceof Tester) {
                System.out.println("Tặng tool Test");
            }

            System.out.println();
        }
    }
}