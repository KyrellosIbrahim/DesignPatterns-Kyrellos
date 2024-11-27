package notificationSystem;

public class WhatsAppNotificationDeco extends NotifChannelCreator {
    public WhatsAppNotificationDeco(INotif notif) {
        super(notif);
    }

    @Override
    public void sendNotification(Notification notification) {
        System.out.println("WhatsApp notification: " + notification.getMessage());
    }
}
