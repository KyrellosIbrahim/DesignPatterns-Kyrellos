package notificationSystem;
import java.util.ArrayList;

public class NotifPreferences {
    private ArrayList<INotif> currentStrategies = new ArrayList<>();

    public void addNotificationPreference(INotif notif) {
        currentStrategies.add(notif);
    }
    public void removeNotificationPreference(INotif notif) {
        currentStrategies.remove(notif);
    }

    public void sendNotification(Notification notification) {
        for (INotif notif : currentStrategies) {
            notif.sendNotification(notification);
        }
    }
}
