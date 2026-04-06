import java.util.Arrays;

// 1. Interface ma he thong moi cua ban yeu cau (Target)
interface Sorter {
    int[] sort(int[] arr);
}

// 2. Thu vien cu khong the sua code (Adaptee)
class LegacySorter {
    public int[] quickSort(int[] arr) {
        System.out.println("Dang sap xep bang thuat toan QuickSort tu thu vien cu...");
        // De mo phong, minh dung ham sort co san cua Java. 
        // Trong thuc te, day se la code thuat toan QuickSort phuc tap cua thu vien cu.
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr); 
        return sortedArr;
    }
}

// 3. Trinh chuyen doi (Adapter)
// Lop nay phai implement interface Sorter ma he thong moi can
class SorterAdapter implements Sorter {
    
    // Chua mot tham chieu den doi tuong cua thu vien cu
    private LegacySorter legacySorter;

    // Constructor de truyen thu vien cu vao
    public SorterAdapter(LegacySorter legacySorter) {
        this.legacySorter = legacySorter;
    }

    // Ghi de phuong thuc cua he thong moi
    @Override
    public int[] sort(int[] arr) {
        // "Dich" loi goi ham tu he thong moi sang ham tuong ung cua thu vien cu
        return legacySorter.quickSort(arr);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Kiem tra mau thiet ke Adapter ===");

        int[] numbers = {42, 15, 8, 99, 23, 4, 16};
        System.out.println("Mang ban dau: " + Arrays.toString(numbers));

        // Khoi tao doi tuong tu thu vien cu
        LegacySorter oldLibrary = new LegacySorter();

        // Tao cuc Adapter, nhet thu vien cu vao trong
        // Luu y: Kieu du lieu cua bien 'adapter' la interface Sorter (he thong moi)
        Sorter adapter = new SorterAdapter(oldLibrary);

        // He thong cua ban chi can goi ham sort() quen thuoc
        int[] sortedNumbers = adapter.sort(numbers);

        System.out.println("Mang sau khi sap xep: " + Arrays.toString(sortedNumbers));
    }
}