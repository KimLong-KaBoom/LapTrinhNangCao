import java.io.*;
import java.util.Scanner;

public class WriteData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dos = null;

        try {
            System.out.print("Nhap ten file: ");
            String fileName = sc.nextLine();

            System.out.print("Nhap so luong n: ");
            int n = sc.nextInt();

            dos = new DataOutputStream(new FileOutputStream(fileName));

            for (int i = 0; i < n; i++) {
                System.out.print("Nhap so thu " + (i + 1) + ": ");
                int x = sc.nextInt();
                dos.writeInt(x);
            }

            System.out.println("Ghi file thanh cong");

        } catch (IOException e) {
            System.out.println("Loi ghi file");
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException e) {
                System.out.println("Loi dong file");
            }
            sc.close();
        }
    }
}

class ReadData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataInputStream dis = null;

        try {
            System.out.print("Nhap ten file: ");
            String fileName = sc.nextLine();

            dis = new DataInputStream(new FileInputStream(fileName));

            System.out.println("Cac so trong file:");

            while (true) {
                int x = dis.readInt();
                System.out.println(x);
            }

        } catch (EOFException e) {
            System.out.println("Da doc het file.");
        } catch (IOException e) {
            System.out.println("Loi doc file");
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                System.out.println("Loi dong file");
            }
            sc.close();
        }
    }
}