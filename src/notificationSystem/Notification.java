package notificationSystem;

public class Notification {
    private String message;
    private NotificationType type;

    public enum NotificationType {
        INFO, WARNING, ERROR
    }

    public Notification(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public NotificationType getType() {
        return type;
    }
}
