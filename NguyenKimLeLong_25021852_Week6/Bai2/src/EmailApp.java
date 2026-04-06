class EmailApp extends NotificationApp {
    protected Notification createNotification() {
        return new EmailNotification();
    }
}