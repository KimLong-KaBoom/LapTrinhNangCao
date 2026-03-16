import java.util.*;

abstract class Employee {

    protected String name;
    protected String employeeId;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public abstract String getType();

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; ++i) {
            String line = sc.nextLine();

            char type = line.charAt(0);
            
            int firstQuote = line.indexOf('"');
            int secondQuote = line.indexOf('"', firstQuote + 1);

            String name = line.substring(firstQuote + 1, secondQuote);

            String rest = line.substring(secondQuote + 2);
            String[] nums = rest.split(" ");
            if(type == 'F') {

                double baseSalary = Double.parseDouble(nums[0]);
                double bonus = Double.parseDouble(nums[1]);
                double penalty = Double.parseDouble(nums[2]);

                employees[i] = new FullTimeEmployee(name, baseSalary, bonus, penalty);

            } else {

                double hours = Double.parseDouble(nums[0]);
                double rate = Double.parseDouble(nums[1]);

                employees[i] = new PartTimeEmployee(name, hours, rate);
            }
        }
        for (Employee i : employees) {
            System.out.println(i.getName() + " - " + i.getType() + " - " + i.calculateSalary());
        }
    }

}

class FullTimeEmployee extends Employee {

    protected double baseSalary, bonus, penalty;

    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (bonus - penalty);
    }

    @Override
    public String getType() {
        return "Full-time";
    }

}

class PartTimeEmployee extends Employee {
    protected double workingHours, hourlyRate;

    public PartTimeEmployee(String name, double workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public String getType() {
        return "Part-time";
    }
}