package notificationSystem;

public class PushNotificationDeco extends NotifChannelCreator {
    public PushNotificationDeco(INotif notif) {
        super(notif);
    }

    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Push notification: " + notification.getMessage());
    }
}
