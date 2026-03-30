public class SmartSpeaker extends Device implements Volume, Wifi{
    SmartSpeaker(String id, String name, String status) {
        super(id, name, status);
    }

    public void connectWifi() {
        System.out.println(name + "connected to wifi");
    }

    public void disconnectWifi() {
        System.out.println(name + "disconnected to wifi");
    }

    public void increaseVolume() {
        System.out.println(name + " increase volume");
    }


    public void decreaseVolume() {
        System.out.println(name + " decrease volume");
    }
}
