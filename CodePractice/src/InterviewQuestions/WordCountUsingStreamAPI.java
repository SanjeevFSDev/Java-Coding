package InterviewQuestions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCountUsingStreamAPI {

	public static void main(String[] args) {
		
		String str = "java concept of the day java concept";

        // Using Java 8 Streams to count each word
        Map<String, Long> wordCount = Arrays.stream(str.split("\\s+")) // Split by spaces
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Printing the word count
        wordCount.forEach((word, count) -> System.out.println(word + " : " + count));
	}

}
