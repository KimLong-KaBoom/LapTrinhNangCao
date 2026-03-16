public class VIPRoom extends Room{
    VIPRoom (char type, int days) {
        super(type, days);
        this.price  = 2000000;
    }

    int getFinalPrice() {
        return price * days;
    }
}
