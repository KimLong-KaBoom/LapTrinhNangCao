public class Person {
    public String name, dob;
    // Person() {
    //     System.out.println("1. Person is created");
    // }
    public Person(String name) {
        System.out.println("1. Person is created");
    }
    public static void main(String[] args) {
        Manager m = new Manager();

    }
}   

class Employee extends Person {
    double salary;
    Employee() {
        super("a");
        System.out.println("2. Employee is created");
    }
}

class Manager extends Employee {
    String department;
    Manager() { 
        System.out.println("3. Manager is created");
    }
}
