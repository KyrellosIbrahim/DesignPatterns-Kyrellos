package notificationSystem;

public class EmailNotification implements INotif {
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Email notification: " + notification.getMessage());
    }
}
