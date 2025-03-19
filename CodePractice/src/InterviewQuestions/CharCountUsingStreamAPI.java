package InterviewQuestions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCountUsingStreamAPI {

	public static void main(String[] args) {
		
		String str = "java concept of the day";
		String vowels = "aeiou";

        // Using Java 8 Streams to count each character
        Map<String, Long> charCount = str.chars()
                .mapToObj(c -> (char) c).filter(c -> c != ' ' && (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ) // Convert int to Character and remove spaces
                .collect(Collectors.groupingBy(Object :: toString, Collectors.counting()));
               // .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Printing the character count
        charCount.forEach((ch, count) -> System.out.println(ch + " : " + count));

	}

}
