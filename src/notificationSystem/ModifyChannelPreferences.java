package notificationSystem;
import java.util.HashMap;
public class ModifyChannelPreferences {
    private final HashMap<String, INotif> channels = new HashMap<>();
    private final NotifPreferences preferences = new NotifPreferences();

    public void addChannel(String channelName, INotif in) {
        channels.put(channelName, in);
    }
    public void enableChannel(String channelName) {
        INotif in = channels.get(channelName);
        if (in != null) {
            preferences.addNotificationPreference(in);
            System.out.println("Channel \"" + channelName + "\" disabled");
        }
    }
    public void disableChannel(String channelName) {
        INotif in = channels.get(channelName);
        if (in != null) {
            preferences.removeNotificationPreference(in);
            System.out.println("Channel \"" + channelName + "\" disabled");
        }
    }
    public void sendNotification(Notification notification) {
        preferences.sendNotification(notification);
    }
}
