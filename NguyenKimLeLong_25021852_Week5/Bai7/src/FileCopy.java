import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            System.out.print("Input file nguon: ");
            String sourcePath = sc.nextLine();

            System.out.print("Input file dich: ");
            String destPath = sc.nextLine();

            br = new BufferedReader(new FileReader(sourcePath));
            pw = new PrintWriter(new FileWriter(destPath));

            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                pw.println(line);
                lineCount++;
            }

            System.out.println("Copy successfully");
            System.out.println("Number of sentences copied: " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found. hoac Cannot create destination file.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                System.out.println("File closed error.");
            }
            sc.close();
        }
    }
}