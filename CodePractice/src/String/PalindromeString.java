package String;

import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sc.nextLine();
		str = str.toLowerCase();
		str = str.replaceAll("[^a-zA-Z]", "");
		
		char ch;
		String reverseString = "";
		
//		for (int i=0; i<str.length(); i++) {
//			ch = str.charAt(i);
//			reverseString = ch + reverseString;
//		}
		
		char[] chArray = str.toCharArray();
		
		for(char chr : chArray) {
			reverseString = chr + reverseString;
		}
		System.out.println(reverseString);
		
		if(str.equals(reverseString)) {
			System.out.println("String is Palindrome");
		}
		else {
			System.out.println("String is Not Palindrome");
		}
	}

}
