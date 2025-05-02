package InterviewQuestions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCountUsingStreamAPI {

	public static void main(String[] args) {
		
		String str = "java concept of the day";
		
		String vowels = "aeiou";
		
		// Using Java 8 Streams to count each character
        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c).filter(c -> !String.valueOf(c).isBlank()) // Convert int to Character and remove spaces
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
               // .collect(Collectors.groupingBy(Object :: toString, Collectors.counting()));
        
        //OR
        Map<String, Long> charCounts = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Using Java 8 Streams to count each vowel character
        Map<Character, Long> vowelCharCount = str.chars()
                .mapToObj(c -> (char) c).filter(c -> c != ' ' && (vowels.indexOf(c) != -1)) // Convert int to Character, remove spaces and check vowels
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
               // .collect(Collectors.groupingBy(Object :: toString, Collectors.counting()));
        
        // Printing the character count     
        charCount.forEach((ch, count) -> System.out.println(ch + " : " + count));

        System.out.println("-----------------------------------------------------");
        
        charCounts.forEach((ch, count) -> System.out.println(ch + " : " + count));
        
        System.out.println("-----------------------------------------------------");
        
        vowelCharCount.forEach((ch, count) -> System.out.println(ch + " : " + count)); 

	}

}
