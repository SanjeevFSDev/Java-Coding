package InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {

	public static void main(String[] args) {

		int [] intArray = {1, 2, 5, 6, 9, 88, 69, 105, 104};
		
		Arrays.sort(intArray);
		
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for(int num : intArray) {
			if(num > largest) {
				secondLargest = largest;
				largest = num;
			}
		}
		System.out.println("Second Largest Value : " + secondLargest);
		
		//By Using Stream API
		Integer secondLargestValue = Arrays.stream(intArray).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("Second Largest Value Using Stream API : " + secondLargestValue);
	}

}
