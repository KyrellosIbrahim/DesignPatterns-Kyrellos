package textFormat;
import java.util.ArrayList;
import java.lang.*;
public class Format {
    /*
    format document in plain text
    format document in HTML output
    format document in Markdown to add formatting
    be able to switch between formatting (plain text, HTML, Markdown) to preview each style
    save the document in selected format to export or publish
    add new custom formatting style in the future (JSON, XML) to adapt to other needs.
    */
    static ArrayList<String> fileContent;
    private IFormat format;

    public Format() {
        fileContent = new ArrayList<>();
    }

    public void setFormat(IFormat format) {
        this.format = format;
    }

    public void printFormatted() {
        format.format(fileContent);
    }


}
