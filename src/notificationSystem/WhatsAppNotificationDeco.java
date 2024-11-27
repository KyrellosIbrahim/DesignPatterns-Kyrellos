package notificationSystem;

public class WhatsAppNotificationDeco implements INotif {

    @Override
    public void sendNotification(Notification notification) {
        System.out.println("WhatsApp notification: " + notification.getMessage());
    }
}
