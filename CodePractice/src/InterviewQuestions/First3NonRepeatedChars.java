package InterviewQuestions;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class First3NonRepeatedChars {

	public static void main(String[] args) {
		
		String s = "ababghji";

        String result = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, // Maintain insertion order
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1) // Only non-repeated
                .limit(3) // First 3
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining());

        System.out.println(result);  // Output: ghj

	}

}
