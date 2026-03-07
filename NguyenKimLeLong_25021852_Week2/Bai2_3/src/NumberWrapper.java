public class NumberWrapper {
    int value;

    public NumberWrapper(int value) {
        this.value = value;
    }

    public int getter() {
        return value;
    }
    
    public void setter(int value) {
        this.value = value;
    }

    public static void swap(NumberWrapper a, NumberWrapper b) {
        int temp = a.getter();
        a.setter(b.getter());
        b.setter(temp);
    }

    public static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);
        System.out.println("n1 = " + n1.getter());
        System.out.println("n2 = " + n2.getter());
        swap(n1, n2);
        System.out.println("Sau khi swap:");
        System.out.println("n1 = " + n1.getter());
        System.out.println("n2 = " + n2.getter());

    }
}
