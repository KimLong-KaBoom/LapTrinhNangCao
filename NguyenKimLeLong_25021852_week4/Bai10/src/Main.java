import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();
        LibrarySection<Book> bookSection = new LibrarySection<>();

        for (int i = 0; i < n; ++i) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            if (type.equals("B")) {
                String author = sc.next();
                int pages = sc.nextInt();
                sc.nextLine();
                bookSection.addMediaItem(new Book(id, name, author, pages));
            } else {
                String director = sc.next();
                int duration = sc.nextInt();
                sc.nextLine();
                dvdSection.addMediaItem(new DVD(id, name, director, duration));
            }
        }
        bookSection.displayAllBooks();
        System.out.println();
        dvdSection.displayAllDVDs();

    }
}
