import java.util.ArrayList;
import java.util.List;

public class Hub {
    List<Device> devices = new ArrayList<>();
    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");
        for (Device i : devices) {
            i.turnOff();
        }
    }

    public void addDevice(Device D) {
        devices.add(D);
    }

    public void setupWifi() {
        System.out.println("Setup Wifi:");
        for (Device d : devices) {
            if (d instanceof Wifi) {
                ((Wifi) d).connectWifi();
            }
        }
    }
}
