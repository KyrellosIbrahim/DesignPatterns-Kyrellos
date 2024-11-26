package textFormat;
public class Main {
    public static void main(String[] args) {

        Format format = new Format();
        format.fileContent.add("This is the sample text in which I would like to format, but then " +
                "\nI can't seem to find the words to put, whether it be lack of thinking, random thoughts, " +
                "\nor just plain old writer's block.");
        format.fileContent.add("If you want to think of something to write, let your hands roam free " +
                "\nand let your mind wander. You'll never know what you'll come up with.");
        format.fileContent.add("It's not necessary to make some sophisticated sentence when testing your program " +
                "\nlay your fingers on the keyboard and let it fly.");


        System.out.println("Plain Text Format:");
        format.setFormat(new PlainTextFormat());
        format.printFormatted();

        System.out.println("\nHTML Format:");
        format.setFormat(new HTMLFormat());
        format.printFormatted();

        System.out.println("\nMarkdown Format:");
        format.setFormat(new MarkdownFormat());
        format.printFormatted();
    }
}