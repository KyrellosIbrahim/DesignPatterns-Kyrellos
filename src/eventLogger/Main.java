package eventLogger;

public class Main {
    public static void main(String[] args) {
        EventLog logger = EventLog.getInstance();
        logger.configureOutput(true, true, "../textFormatter/src/eventLogger/test1.log");
        logger.log(EventLog.logLevel.INFO, "This is an info message");
        logger.log(EventLog.logLevel.WARNING, "This is a warning message");
        logger.log(EventLog.logLevel.ERROR, "This is an error message");
        logger.log(EventLog.logLevel.DEBUG, "This is a debug message");

        System.out.println("Log destinations:");
        logger.getLogDestinations().forEach(System.out::println);
    }
}
