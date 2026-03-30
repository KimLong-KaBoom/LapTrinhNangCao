public class BedroomAC extends Device implements Wifi{
    BedroomAC(String id, String name, String status) {
        super(id, name, status);
    }

    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }

    public void disconnectWifi() {
        System.out.println(name + " disconnected to wifi");
    }
}
