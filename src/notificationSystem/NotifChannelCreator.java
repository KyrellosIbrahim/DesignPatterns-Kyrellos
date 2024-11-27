package notificationSystem;

public abstract class NotifChannelCreator implements INotif {
    protected INotif wrappedNotif;

    public NotifChannelCreator(INotif notif) {
        this.wrappedNotif = notif;
    }

    @Override
    public void sendNotification(Notification notification) {
        wrappedNotif.sendNotification(notification);
    }
}
