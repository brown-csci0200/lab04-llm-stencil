import java.util.List;
import java.util.function.Function;

public class FilterAndPrint {
    /**
     * Filters and prints strings from a list based on a given predicate function
     *
     * @param strings The list of strings to filter
     * @param filter  A Function that takes a String and returns Boolean
     */
    public static void filterPrintList(List<String> strings, Function<String, Boolean> filter) {
        for (String str : strings) {
            if (filter.apply(str)) {
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {

        // Example usage
        System.out.println("\n=== Testing FilterAndPrint class ===");

        List<String> sampleStrings = Arrays.asList(
                "Joe: Hello there",
                "Mary: How are you?",
                "Joe: I'm doing well",
                "Bob: Great weather today",
                "ERROR: Connection failed",
                "INFO: Process completed",
                "This is a very long line that exceeds fifty characters in total length",
                "Short line",
                "",
                "Line with 123 numbers",
                "alice@example.com",
                "bob@Joe.org"
        );

        System.out.println("\n--- FilterList: Strings starting with 'Joe:' ---");
        filterPrintList(sampleStrings, str -> str.startsWith("Joe:"));

        System.out.println("\n--- FilterList: Strings containing email addresses ---");
        filterPrintList(sampleStrings, str -> str.contains("@"));

        System.out.println("\n--- FilterList: Strings longer than 20 characters ---");
        filterPrintList(sampleStrings, str -> str.length() > 20);
    }
}