package String;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramString {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the first string");
		
		String str1 = sc1.nextLine();
		str1 = str1.toLowerCase();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the second string");
		
		String str2 = sc2.nextLine();
		str2 = str2.toLowerCase();
		
		if(checkAnagram(str1, str2)){
			System.out.println("Strings are Anagram");
		}
		else {
			System.out.println("Strings are Not Anagram");
		}

	}

	public static boolean checkAnagram(String str1, String str2) {
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		char [] arrayStr1 = str1.toCharArray();
		char [] arrayStr2 = str2.toCharArray();
		
		Arrays.sort(arrayStr1);
		Arrays.sort(arrayStr2);
		
		String sortedStr1 = new String(arrayStr1);
		String sortedStr2 = new String(arrayStr2);
		
		if(sortedStr1.equals(sortedStr2)) {
			return true;
		}
		return false;
	}

}
