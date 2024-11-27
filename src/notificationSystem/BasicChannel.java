package notificationSystem;

public class BasicChannel implements Channel {
    protected String channelName
    @Override
    public void sendNotification(Notification notification) {
        System.out.println(notification.getMessage());
    }

    protected void log(Notification n) {
        System.out.printf("[%s] %s: %s\n",
                channelName, n.getType(), n.getMessage());
    }
}
