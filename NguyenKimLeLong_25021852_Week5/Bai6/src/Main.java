import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("a: ");
            int a = sc.nextInt();

            System.out.print("b: ");
            int b = sc.nextInt();

            int result = a / b;
            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Input has to be an Interger.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot devided by Zero.");
        } finally {
            System.out.println("Program finished.");
        }

        sc.close();
    }
}