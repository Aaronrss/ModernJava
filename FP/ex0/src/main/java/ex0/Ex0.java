package ex0;

import static java.util.function.Predicate.not;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This example shows two method implementations that remove a string
 * from a list of strings. One method uses classic Java 7 features
 * and the other uses basic modern Java features.
 */
@SuppressWarnings("SameParameterValue")
public class Ex0 {
        /**
         * The main entry point into this program.
         */
        static public void main(String[] args) {
                boolean verbose = Arrays.asList(args).contains("-v")
                                || Arrays.asList(args).contains("--verbose");

                // The array of names.
                String[] nameArray = {
                                "Barbara", "James", "Mary", "John", "Robert",
                                "Michael", "Linda", "james", "mary"
                };

                List<String> input = List.of(nameArray);

                // Remove "Robert" from the list created from nameArray.
                List<String> l1 = zap7(input,
                                "Robert");

                // Remove "Robert" from the list created from nameArray.
                List<String> l2 = zapModern(input,
                                "Robert");

                // Print the results.
                if (verbose) {
                        System.out.println("Entrada: " + input);
                        System.out.println("zap7 (Java 7): " + l1);
                        System.out.println("zapModern (8+): " + l2);

                }

                // Check to ensure the zap*() methods work.
                if (l1.contains("Robert")
                                || l2.contains("Robert"))
                        System.out.println("Test failed");
                else
                        System.out.println("Test succeeded");
        }

        /**
         * Remove any strings matching {@code omit} from the list of
         * strings using basic Java 7 features.
         */
        static List<String> zap7(List<String> lines,
                        String omit) {
                // Create an ArrayList to return the results.
                List<String> results = new ArrayList<>();

                // Iterate through all the lines in the List.
                for (String line : lines)
                        // If 'line' doesn't equal 'omit'
                        // add it to the List of results.
                        if (!omit.equals(line))
                                results.add(line);

                // Return the List of results.
                return results;
        }

        /**
         * Remove any strings matching {@code omit} from the list of
         * strings using basic modern Java features.
         */
        static List<String> zapModern(List<String> lines,
                        String omit) {
                return lines
                                // Convert the List to a sequential stream.
                                .stream()

                                // Remove any strings that match omit.
                                .filter(not(omit::equals))

                                // Trigger intermediate operation processing and return
                                // new list of results.
                                // .collect(toList());
                                .toList();
        }
}
