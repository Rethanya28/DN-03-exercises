public class ContentCreatorPattern {

    // File interface
    public interface File {
        void start();
        void end();
    }

    // TextFile class
    public static class TextFile implements File {
        @Override
        public void start() {
            System.out.println("Starting Text File");
        }

        @Override
        public void end() {
            System.out.println("Ending Text File");
        }
    }

    // EbookFile class
    public static class EbookFile implements File {
        @Override
        public void start() {
            System.out.println("Starting E-Book File");
        }

        @Override
        public void end() {
            System.out.println("Ending E-Book File");
        }
    }

    // SpreadsheetFile class
    public static class SpreadsheetFile implements File {
        @Override
        public void start() {
            System.out.println("Starting Spreadsheet File");
        }

        @Override
        public void end() {
            System.out.println("Ending Spreadsheet File");
        }
    }

    // FileFactory abstract class
    public static abstract class FileFactory {
        public abstract File generateFile();
    }

    // TextFileFactory class
    public static class TextFileFactory extends FileFactory {
        @Override
        public File generateFile() {
            return new TextFile();
        }
    }

    // EbookFileFactory class
    public static class EbookFileFactory extends FileFactory {
        @Override
        public File generateFile() {
            return new EbookFile();
        }
    }

    // SpreadsheetFileFactory class
    public static class SpreadsheetFileFactory extends FileFactory {
        @Override
        public File generateFile() {
            return new SpreadsheetFile();
        }
    }

    // Test the Factory Method Implementation
    public static void main(String[] args) {
        FileFactory textFactory = new TextFileFactory();
        File textFile = textFactory.generateFile();
        textFile.start();
        textFile.end();

        FileFactory ebookFactory = new EbookFileFactory();
        File ebookFile = ebookFactory.generateFile();
        ebookFile.start();
        ebookFile.end();

        FileFactory spreadsheetFactory = new SpreadsheetFileFactory();
        File spreadsheetFile = spreadsheetFactory.generateFile();
        spreadsheetFile.start();
        spreadsheetFile.end();
    }
}
