package notificationSystem;

public class SlackNotification implements INotif {
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Slack notification: " + notification.getMessage());
    }
}
