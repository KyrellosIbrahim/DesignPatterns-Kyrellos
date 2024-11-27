package notificationSystem;

public class BasicNotification {
    public void sendNotification(String message) {
        Notification notification = new Notification(message);
        System.out.println("Basic notification: " + message);
    }
}
