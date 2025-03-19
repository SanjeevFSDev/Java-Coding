package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindNumberUsingOptional {
	
	private static boolean findNumber(List<Integer> list, int num) {
		Optional<Integer> result = list.stream().filter(n -> n == num).findFirst(); // Finds the first matching number (if exists)
		return result.isPresent(); // Returns true if found, otherwise false	
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int numToFind = 30;

        boolean isFound = findNumber(numbers, numToFind);
        System.out.println("Number " + numToFind + " found: " + isFound);
	}
}
