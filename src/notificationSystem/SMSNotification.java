package notificationSystem;

public class SMSNotification implements INotif {
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("SMS notification: " + notification.getMessage());
    }
}
