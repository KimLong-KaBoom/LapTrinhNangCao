public class MathUtils {
    public int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5, 5));
        // System.out.println(m.sum(5.5, 5.5));
    }
}
