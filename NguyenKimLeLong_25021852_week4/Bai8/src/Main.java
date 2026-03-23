import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Hub hub = new Hub();
        for (int i = 0; i < n; ++i)
        {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            String status = "off";
            if (type.equals("L")) {
                hub.addDevice(new LivingRoomLight(id, name, status));
            } else if (type.equals("AC")){
                hub.addDevice(new BedroomAC(id, name, status));
            } else if (type.equals("S")) {
                hub.addDevice(new SmartSpeaker(id, name, status));
            } else if (type.equals("C")) {
                hub.addDevice(new WindowCurtain(id, name, status));
            }
        }
        hub.turnOffAll();
        hub.setupWifi();
        
    }
}

interface Enable {
    void turnOn();
    void turnOff();
}

interface Brightness {
    void increaseBrightness();
    void decreaseBrightness();
}

interface Wifi {
    void connectWifi();
    void disconnectWifi();
}

interface Volume {
    void increaseVolume();
    void decreaseVolume();
}
