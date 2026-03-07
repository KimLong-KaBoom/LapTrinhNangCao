public class SmartLight {
    private String id, name;
    private int brightness;

    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public void setBrightness(String preset) {
        if (preset == "MAX")
            this.setBrightness(100);
        else if (preset == "MIN") 
            this.setBrightness(10);
        else 
            this.setBrightness(30);
    }

    void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        CentralHub hub = new CentralHub();
        SmartLight l1 = new SmartLight("L01", "Livingroom's light", 80);
        SmartLight l2 = new SmartLight("L02", "Bedroom's light");

        l2.setBrightness("ECO");
        l1.connectToHub(hub); l2.connectToHub(hub);
        System.out.println("1: Brightness: " + l1.brightness);
        System.out.println("1: Brightness: " + l2.brightness);

    }
}

class CentralHub {
    public void registerDevice(SmartLight light) {
        System.out.println("[Hub] Đang kết nối với thiết bị: " + light.getName());
        
    }
}