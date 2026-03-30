import java.util.ArrayList;
import java.util.List;

class Store<T extends Product> {
    List<T> items = new ArrayList<>();

    // Nhập kho
    public void add(T item) {
        items.add(item);
    }

    // Xuất kho (lấy ra phần tử cuối)
    public void remove() {
        if (!items.isEmpty()) {
            items.remove(items.size() - 1);
        }
    }

    // Kiểm kê
    public void displayAll() {
        for (T item : items) {
            item.display();
        }
    }
}
