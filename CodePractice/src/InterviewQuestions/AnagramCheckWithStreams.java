package InterviewQuestions;

import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramCheckWithStreams {
    public static void main(String[] args) {
        String s1 = "RaceCar";
        String s2 = "CarRace";

        if (areAnagramsUsingStreams(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams.");
        }
    }

    public static boolean areAnagramsUsingStreams(String str1, String str2) {
        // Normalize the strings: remove whitespace and convert to lowercase
        String s1 = str1.replaceAll("\\s+", "").toLowerCase();
        String s2 = str2.replaceAll("\\s+", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        // Build frequency maps using streams
        return s1.chars()
                 .mapToObj(c -> (char) c)
                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                 .equals(
                     s2.chars()
                       .mapToObj(c -> (char) c)
                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                 );
    }
}

