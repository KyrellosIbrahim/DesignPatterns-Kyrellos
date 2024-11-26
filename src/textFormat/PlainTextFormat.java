package textFormat;
import java.util.ArrayList;

public class PlainTextFormat implements IFormat {

    @Override
    public void format(ArrayList<String> data) {
        for (String s : Format.fileContent) {
            System.out.println(s);
        }
    }
}
