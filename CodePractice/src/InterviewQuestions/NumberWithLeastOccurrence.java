package InterviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberWithLeastOccurrence {
    public static void main(String[] args) {
        int[] input = {1, 2, 1, 3, 4, 5, 3, 6, 6, 8};

        // Step 1: Convert to List for easier stream operations
        List<Integer> inputList = Arrays.stream(input).boxed().toList();

        // Step 2: Count frequencies using a LinkedHashMap to preserve order
        Map<Integer, Long> freqMap = inputList.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Step 3: Find the minimum frequency
        long minCount = Collections.min(freqMap.values());

        // Step 4: Find the first number with the minimum frequency
        Integer result = inputList.stream()
                .filter(num -> freqMap.get(num) == minCount)
                .findFirst()
                .orElse(null);

        System.out.println("First number with least occurrence: " + result);
    }
}

