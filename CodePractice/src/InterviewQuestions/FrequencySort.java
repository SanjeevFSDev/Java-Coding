package InterviewQuestions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {
	
	public static void main(String[] args) {
        String str = "aabtsscceeadjee";

        String result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining());

        System.out.println(result); // Output: eacsbtdj
    }

}
