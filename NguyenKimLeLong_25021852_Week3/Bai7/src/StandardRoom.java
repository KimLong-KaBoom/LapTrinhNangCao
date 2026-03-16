public class StandardRoom extends Room{

    StandardRoom (char type, int days) {
        super(type, days);
        this.price = 500000;
    }

    int getFinalPrice() {
        if (days > 3)
            return (int)((price * days) * 0.95);
        return price * days;
    }
}
