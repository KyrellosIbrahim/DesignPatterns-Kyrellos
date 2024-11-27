package eventLogger;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventLog {
    private static volatile EventLog instance;
    private List<String> logDestinations = new CopyOnWriteArrayList<>();
    private static final String LOG_FILE = "app.log";

    public String currentFile = LOG_FILE;
    private boolean consoleEnabled = true;
    private boolean fileEnabled = false;
    private List<ILogger> logs = new ArrayList<>();

    public enum logLevel {
        INFO,
        WARNING,
        ERROR,
        DEBUG
    }
    private EventLog() {
    }

    public static EventLog getInstance() {
        if (instance == null) {
            synchronized (EventLog.class) {
                if (instance == null) {
                    instance = new EventLog();
                }
            }
        }
        return instance;
    }

    public void configureOutput(boolean consoleEnabled, boolean fileEnabled) {
        this.consoleEnabled = consoleEnabled;
        this.fileEnabled = fileEnabled;
    }
    public void configureOutput(boolean consoleEnabled, boolean fileEnabled, String file) {
        this.consoleEnabled = consoleEnabled;
        this.fileEnabled = fileEnabled;
        this.currentFile = file;
    }

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private String formatLogEntry(LocalDateTime timestamp, logLevel level, String message) {
        return String.format("[%s] %s: %s", timestamp.format(dtf), level.name(), message);
    }

    public void log(logLevel level, String message) {
        LocalDateTime timestamp = LocalDateTime.now();
        String entry = formatLogEntry(timestamp, level, message);
        if (consoleEnabled) {
            System.out.println(entry);
        }
        if (fileEnabled) {
            try {
                FileWriter writer = new FileWriter(currentFile, true);
                writer.write(entry + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!logs.isEmpty()) {
            for(ILogger log : logs) {
                log.write(entry);
            }
        }
        logDestinations.add(entry);
    }

    public List<String> getLogDestinations() {
        return Collections.unmodifiableList(logDestinations);
    }
    public void LogToFile(logLevel level, String message, String filepath) {
        try(FileWriter writer = new FileWriter(filepath, true)) {
            LocalDateTime timestamp = LocalDateTime.now();
            String entry = formatLogEntry(timestamp, level, message);
            writer.write(entry + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void archiveLogs() {
        archiveLogs(LOG_FILE);
    }
    public void archiveLogs(String sourcepath) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String archivepath = "logArchive_" + timestamp + ".log";
        try {
            Files.copy(Paths.get(sourcepath), Paths.get(archivepath));
            new FileWriter (sourcepath, false).close();
            log(logLevel.INFO, "Logs archived to " + sourcepath);
        } catch (IOException e) {
            log(logLevel.ERROR, "Failed to archive logs: " + e.getMessage());
        }
    }
    public void addDestination(ILogger log) {
        logs.add(log);
    }
    public void removeDestination(ILogger log) {
        logs.remove(log);
    }
}
