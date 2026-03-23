public class LivingRoomLight extends Device implements Brightness{
    
    LivingRoomLight (String id, String name, String status) {
        super(id, name, status);
    }
    public void increaseBrightness() {
        System.out.println(name + " increased brightness");
    }

    public void decreaseBrightness() {
                System.out.println(name + " decreased brightness");

    }
}
