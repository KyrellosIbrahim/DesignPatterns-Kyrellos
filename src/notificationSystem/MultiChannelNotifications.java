package notificationSystem;
import java.util.ArrayList;

public class MultiChannelNotifications {
    private ArrayList<INotif> channels = new ArrayList<>();

    public void addChannel(INotif channel) {
        channels.add(channel);
    }
    public void removeChannel(INotif channel) {
        channels.remove(channel);
    }
    public void sendMultiChannelNotification(Notification n) {
        for (INotif channel : channels) {
            channel.sendNotification(n);
        }
    }
}
