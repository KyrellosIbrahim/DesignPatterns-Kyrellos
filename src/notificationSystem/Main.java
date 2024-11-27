package notificationSystem;

public class Main {
    public static void main(String[] args) {
        //general notification
        Notification maintenance = new Notification("Maintenance is scheduled for 3:00 AM CST and " +
                "is expected to last for 2 hours.");

        //initialize the channels
        ModifyChannelPreferences mcp = new ModifyChannelPreferences();
        mcp.addChannel("Email", new EmailNotification());
        mcp.addChannel("SMS", new SMSNotification());
        mcp.addChannel("WhatsApp", new WhatsAppNotificationDeco());
        mcp.addChannel("Slack", new SlackNotification());

        //enable and disable channels
        mcp.enableChannel("Email");
        mcp.enableChannel("SMS");
        mcp.enableChannel("WhatsApp");
        mcp.disableChannel("Slack");

        //send notifications through individual channels
        INotif email = new EmailNotification();
        INotif sms = new SMSNotification();
        email.sendNotification(maintenance);
        sms.sendNotification(maintenance);


        //send notifications through multiple channels
        MultiChannelNotifications mcn = new MultiChannelNotifications();
        mcn.addChannel(new EmailNotification());
        mcn.addChannel(new SMSNotification());
        mcn.sendMultiChannelNotification(maintenance);

        //print notification history
        NotificationHistory h = NotificationHistory.getInstance();
        h.addRecord(maintenance, "Email");
        h.addRecord(maintenance, "SMS");
        h.printRecords();

        //decorators
        INotif push = new PushNotificationDeco();
        INotif whatsapp = new WhatsAppNotificationDeco();
        push.sendNotification(maintenance);
        whatsapp.sendNotification(maintenance);
    }
}
