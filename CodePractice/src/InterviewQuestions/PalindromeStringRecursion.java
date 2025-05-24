package InterviewQuestions;

public class PalindromeStringRecursion {

	public static void main(String[] args) {
		System.out.println(isPalindrome("RaceCar"));                    // true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("No lemon, no melon"));         // true
        System.out.println(isPalindrome("Hello World"));                // false
        System.out.println(isPalindrome("abba"));  					// true  
	}

	private static boolean isPalindrome(String str) {
		String cleanedString = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int left = 0, right = cleanedString.length()-1;
		if(checkPalindrom(cleanedString, left, right)) {
			return true;
		}
		return false;
	}

	private static boolean checkPalindrom(String cleanedString, int left, int right) {
		if(left>=right) return true;
		else if(cleanedString.charAt(left) == cleanedString.charAt(right)) {
			return checkPalindrom(cleanedString, left + 1, right - 1);
		}
		else{
			return false;
		}
	}

}
