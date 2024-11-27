package notificationSystem;

public class PushNotificationDeco implements INotif {

    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Push notification: " + notification.getMessage());
    }
}
