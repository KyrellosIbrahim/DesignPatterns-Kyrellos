package eventLogger;

public class ConsoleLogDestination implements ILogger {

    @Override
    public void write(String entry) {
        System.out.println(entry);
    }
}
