import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();

            students.add(new Student(id, name, gpa));
        }
        students.removeIf(s -> s.getGpa() < 5);
        System.out.println("After removing GPA < 5.0:");
        students.forEach(s -> System.out.println(s.getId() + " " + s.getName() + " " + s.getGpa()));
        System.out.println();
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("After sorting by name:");
        students.forEach(s -> System.out.println(s.getId() + " " + s.getName() + " " + s.getGpa()));
        
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> a / b;

    }
}
