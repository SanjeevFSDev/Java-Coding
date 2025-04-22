package InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringLengthStreamAPI {

	public static void main(String[] args) {
		
		String[] strArray = {"Java", "Spring", "ReactJs", "Angular", "Microservices"};
		
		String longestString = Arrays.stream(strArray).max(Comparator.comparing(String :: length)).get();
		
		String longestString1 = Arrays.stream(strArray).max((a, b) -> (a.length() > b.length()) ? 1 : -1).get();
		
		System.out.println(longestString);
		System.out.println(longestString1);

	}

}
