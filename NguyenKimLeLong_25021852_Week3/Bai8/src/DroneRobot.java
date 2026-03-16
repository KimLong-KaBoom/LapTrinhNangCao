public class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {

    DroneRobot (int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getName() + " performing main task");
    }

    public void fly() {
        System.out.println(getName() + " flying");
    }

    public void getCoordinates() {
        System.out.println(getName() + " getting coordinates");
    }

    public void turnOn() {
        System.out.println(getName() + " turning on");
    }
}