abstract public class Employee implements IWorkable{
    String id, name;
    double baseSalary;
    abstract double calculatePay();
    Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
}

interface IWorkable {
    void work();
}

class OfficeWorker extends Employee {

    OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    double calculatePay() {
        return (baseSalary);
    }

    public void work() {
        System.out.println("Drafting documents...");
    }
}

class Technicion extends Employee{

    int overtimeHours;

    Technicion(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }
    double calculatePay() {
        return (baseSalary + overtimeHours * 20000);
    }
    public void work() {
        System.out.println("Installing the equipment...");
    }
}