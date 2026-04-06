public class SmsNotification implements Notification {
    public void send(String msg) {
        System.out.println("Send SMS: " + msg);
    }
}
