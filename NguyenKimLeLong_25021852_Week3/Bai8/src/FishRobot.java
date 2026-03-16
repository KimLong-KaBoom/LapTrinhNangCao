public class FishRobot extends Robot implements Swimmable {

    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getName() + " performing main task");
    }

    public void swim() {
        System.out.println(getName() + " swimming");
    }
}
