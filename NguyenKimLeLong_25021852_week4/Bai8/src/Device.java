public abstract class Device implements Enable{
    public String id, name, status;
    public Device (String id,  String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public void turnOff() {
        System.out.println(name + " turned off");
    }

    public void turnOn() {
        System.out.println(name + " turned on");
    }
}
