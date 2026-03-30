import java.util.*;

class LibraryArrayList {
    List<Book> list = new ArrayList<>();

    public void addBook(Book b) {
        list.add(b);
    }

    public Book findById(String id) {
        for (Book b : list) {
            if (b.id.equals(id)) {
                return b;
            }
        }
        return null;
    }

    public void removeById(String id) {
        list.removeIf(b -> b.id.equals(id));
    }

    public void display() {
        for (Book b : list) {
            System.out.println(b);
        }
    }
}