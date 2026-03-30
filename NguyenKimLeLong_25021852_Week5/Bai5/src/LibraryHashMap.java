import java.util.*;

class LibraryHashMap {
    Map<String, Book> map = new HashMap<>();

    public void addBook(Book b) {
        map.put(b.id, b);
    }

    public Book findById(String id) {
        return map.get(id);
    }

    public void removeById(String id) {
        map.remove(id);
    }

    public void display() {
        for (Book b : map.values()) {
            System.out.println(b);
        }
    }
}