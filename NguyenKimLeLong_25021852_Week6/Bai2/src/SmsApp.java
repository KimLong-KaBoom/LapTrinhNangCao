class SmsApp extends NotificationApp {
    protected Notification createNotification() {
        return new SmsNotification();
    }
}