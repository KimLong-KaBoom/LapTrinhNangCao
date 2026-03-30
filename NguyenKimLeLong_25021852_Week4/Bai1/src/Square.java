public class Square extends Shape{
    Square(int x, int y) {
        super(x, y);
    }

    public void draw() {
        System.out.println("Vẽ hình vuông tại (" + x +", " + y + ")");
    }

    public void erase() {
        System.out.println("Xóa hình vuông tại (" + x +", " + y + ")");
    }
}
