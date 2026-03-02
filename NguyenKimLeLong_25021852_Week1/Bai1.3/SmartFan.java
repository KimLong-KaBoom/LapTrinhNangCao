
package NguyenKimLeLong_25021852_Week1;
public class SmartFan {
    // ========== Trạng thái ================
    private String brand = "Xiaomi";
    private boolean isPowerOn = false;
    private int speedLevel = 0; // Mức từ 1 đến 3

    // ========== Hành vi ===================
    public void turnOn() {
        this.isPowerOn = true;
    }

    // ========== Hành vi ===================
    public void turnOff() {
        this.isPowerOn = false;
        this.speedLevel = 0;
    }

    // ========== Hành vi ===================
    public void setSpeed(int newSpeed) {
        // Chỉ đổi tốc độ nếu quạt đang bật
        if (this.isPowerOn == true) { 
            this.speedLevel = newSpeed;
        }
    }

    public static void main(String[] args) {
        // ===== Định danh ========
        SmartFan livingRoomFan = new SmartFan();

        // ===== Hành vi ==========
        livingRoomFan.turnOn();
        livingRoomFan.setSpeed(2);

        // ===== Định danh ========
        SmartFan bedroomFan = new SmartFan();

        // ===== Hành vi ==========
        bedroomFan.setSpeed(3); 
        bedroomFan.turnOn();
    }
}
