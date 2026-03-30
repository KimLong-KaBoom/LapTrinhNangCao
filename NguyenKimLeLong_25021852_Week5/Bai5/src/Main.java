import java.util.*;

public class Main {
    public static void main(String[] args) {

        int n = 100000;

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            books.add(new Book(String.valueOf(i), "Title" + i, "Author" + i, 2000 + i % 20));
        }

        // ===== ArrayList ====
        LibraryArrayList l1 = new LibraryArrayList();
        for (Book b : books) l1.addBook(b);

        long start1 = System.nanoTime();
        l1.findById("99999");
        long end1 = System.nanoTime();

        System.out.println("ArrayList search: " + (end1 - start1) + " ns");


        // ===== HashMap =====
        LibraryHashMap l2 = new LibraryHashMap();
        for (Book b : books) l2.addBook(b);

        long start2 = System.nanoTime();
        l2.findById("99999");
        long end2 = System.nanoTime();

        System.out.println("HashMap search: " + (end2 - start2) + " ns");


        // ===== TreeMap =====
        LibraryTreeMap l3 = new LibraryTreeMap();
        for (Book b : books) l3.addBook(b);

        long start3 = System.nanoTime();
        l3.findById("99999");
        long end3 = System.nanoTime();

        System.out.println("TreeMap search: " + (end3 - start3) + " ns");
    }
}