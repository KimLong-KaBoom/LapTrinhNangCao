import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        System.out.println("Nhap danh sach sinh vien (nhap END de dung):");

        while (true) {
            System.out.print("Nhap id: ");
            String id = sc.nextLine();
            if (id.equals("END")) break;

            System.out.print("Nhap ten: ");
            String name = sc.nextLine();

            System.out.print("Nhap GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            list.add(new Student(id, name, gpa));
        }

        ObjectOutputStream oos = null;
        try {
            System.out.print("Nhap ten file de ghi: ");
            String fileName = sc.nextLine();

            oos = new ObjectOutputStream(new FileOutputStream(fileName));

            for (Student s : list) {
                oos.writeObject(s);
            }

            System.out.println("Ghi file thanh cong!");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("I/O error!");
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {}
        }

        ObjectInputStream ois = null;
        try {
            System.out.print("Nhap ten file: ");
            String fileName = sc.nextLine();

            ois = new ObjectInputStream(new FileInputStream(fileName));
            
            System.out.println("Danh sach sinh vien:");

            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s);
            }

        } catch (EOFException e) {
            System.out.println("Da doc het file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (IOException e) {
            System.out.println("I/O error!");
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {}
            sc.close();
        }
    }
}