import java.util.Scanner;

abstract public class Room {
    int price;
    int days;
    char type;
    Room(char type, int days) {
        this.type = type;
        this.days = days;
    }

    abstract int getFinalPrice();

    public static void main() {
        Scanner sc = new Scanner(System.in);
        char type = sc.next().charAt(0);
        int days = sc.nextInt();

        if (type == 'V') {
            Room vipRoom = new VIPRoom(type, days);
            System.out.println(vipRoom.getFinalPrice());
        }
        else {
            Room standardRoom = new StandardRoom(type, days);
            System.out.println(standardRoom.getFinalPrice());
        }
    }
}
