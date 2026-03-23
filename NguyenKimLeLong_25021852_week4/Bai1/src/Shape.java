public abstract class Shape {
    protected int x, y;
    Shape (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw();
    public abstract void erase();

    public void moveTo(int newX, int newY) {
        erase();
        x = newX;
        y = newY;
        draw();
    };
}
