public class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {

    AmphibiousRobot (int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getName() + " performing main task");
    }

    public void fly() {
        System.out.println(getName() + " flying");
    }

    public void swim() {
        System.out.println(getName() + " swimming");
    }

    public void getCoordinates() {
        System.out.println(getName() + " getting coordinates");
    }

}
