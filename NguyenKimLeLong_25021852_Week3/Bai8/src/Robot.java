import java.util.Scanner;

abstract public class Robot {
    private int id, batteryLevel;
    private String modelName;

    public String getName() {
        return modelName;
    }

    Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public void chargeBattery() {
        batteryLevel = 100;
    }

    final public void showIdentity() {
        System.out.println("id: " + id);
        System.out.println("model: " + modelName);
    }

    abstract void performMainTask();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int id = sc.nextInt();
            String name = sc.next();

            if (type.equals("DR")) {
                robots[i] = new DroneRobot(id, name);
            }
            else if (type.equals("FR")) {
                robots[i] = new FishRobot(id, name);
            }
            else if (type.equals("AR")) {
                robots[i] = new AmphibiousRobot(id, name);
            }
        }
        for (Robot r : robots) {

            r.performMainTask();

            if (r instanceof Flyable) {
                ((Flyable) r).fly();
            }

            if (r instanceof Swimmable) {
                ((Swimmable) r).swim();
            }

            if (r instanceof GPS) {
                ((GPS) r).getCoordinates();
            }

            System.out.println();
        }
    }
}

interface ElectronicDevice {
    void turnOn();
}

interface Flyable {
    void fly();
    
}

interface Swimmable {
    void swim();
    
}

interface GPS {
    void getCoordinates();  
    
}