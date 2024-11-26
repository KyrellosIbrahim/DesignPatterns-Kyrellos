package textFormat;
import java.util.ArrayList;
import java.util.Random;

public class MarkdownFormat implements IFormat{
    @Override
    public void format(ArrayList<String> data) {
        String[] options = {"**", "***", "<sub>", "~~", "_"};
        Random rng = new Random();
        System.out.println("#" + data.get(0));
        for(int i = 1; i < data.size(); i++) {
            int number = rng.nextInt(options.length);
            String option = options[number];
            System.out.println(option + data.get(i) + option);
        }
    }
}
