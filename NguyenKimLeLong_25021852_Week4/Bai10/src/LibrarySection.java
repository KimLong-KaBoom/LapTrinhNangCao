import java.util.ArrayList;
import java.util.List;

public class LibrarySection<T extends MediaItem> {
    List<T> products = new ArrayList<>();

    
    public void addMediaItem(T item) {
        products.add(item);
    }

    public void displayAllBooks() {
        System.out.println("Khu vực sách:");
        for (T i : products) {
            i.display();
        }
    }

    public void displayAllDVDs() {
        System.out.println("Khu vực DVD:");
        for (T i : products) {
            i.display();
        }
    }
}
