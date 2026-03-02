public class Student {
    private String id, name, email;
    private double gpa;

    public Student() {
        this.gpa = 0.0;
        this.email = "";
        this.id = "";
        this.name = "";
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.gpa = 0.0;
        this.email = "";
    }

    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gpa = gpa;
    }

    public void setGpa(double gpa) {
        if (gpa > 0 && gpa < 4)
            this.gpa = gpa;
        else {
            System.out.println("Gpa không hợp lệ");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("100000", "Kim Long");
        Student student3 = new Student("100001", "Tai Anh", "Tanh123@gmail.com", 3.67);
        student2.setGpa(-1);
        System.out.println(student1.gpa);
        System.out.println(student2.gpa);
        System.out.println(student3.gpa);
    }
}
