package notificationSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;

public class NotificationHistory {
    private static NotificationHistory instance;
    private final List<NotificationRecord> records = new ArrayList<>();

    // Make NotificationRecord a static nested class for proper encapsulation
    public static class NotificationRecord {
        private final LocalDateTime time;
        private final Notification notification;
        private final String channel;

        public NotificationRecord(Notification notification, String channel) {
            this.time = LocalDateTime.now();
            this.notification = notification;
            this.channel = channel;
        }

        public LocalDateTime getTime() {
            return time;
        }

        public Notification getNotification() {
            return notification;
        }

        public String getChannel() {
            return channel;
        }

        @Override
        public String toString() {
            return String.format("[%s] Channel: %s, Type: %s, Message: %s",
                    time, channel,
                    notification.getType(), notification.getMessage());
        }
    }

    private NotificationHistory() {}

    public static synchronized NotificationHistory getInstance() {
        if (instance == null) {
            instance = new NotificationHistory();
        }
        return instance;
    }

    public synchronized void addRecord(Notification notification, String channel) {
        records.add(new NotificationRecord(notification, channel));
    }

    public synchronized List<NotificationRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }

    public synchronized void printRecords() {
        records.forEach(System.out::println);
    }
}
