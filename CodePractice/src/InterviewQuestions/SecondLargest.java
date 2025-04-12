package InterviewQuestions;

import java.util.Arrays;

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

	}

}
