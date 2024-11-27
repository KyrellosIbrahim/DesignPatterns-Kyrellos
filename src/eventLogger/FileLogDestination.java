package eventLogger;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogDestination implements ILogger {
    private String filename;

    @Override
    public void write(String entry) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(entry + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
