public class Main {
    public static void main(String[] args) {
        Integer[] a = {5, 1, 3, 2};
        ArrayUtils.sort(a);
        for (int i : a){
            System.out.print(i + " ");
        }
        System.out.println();

        String[] b = {"Java", "C++", "Python"};
        ArrayUtils.sort(b);
        for (String i : b){
            System.out.print(i + " ");
        }
        System.out.println();
        Student[] c = {
            new Student("Long A", 3.2),
            new Student("Long B", 2.5),
            new Student("Long C", 3.8)
        };
        ArrayUtils.sort(c);
        // for (Student i : c) {
        //     System.out.print(i.toString() + "\n");
        // }
    }
    
}

class Student implements Comparable<Student> {
    String name;
    double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.gpa, o.gpa);
    }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}
