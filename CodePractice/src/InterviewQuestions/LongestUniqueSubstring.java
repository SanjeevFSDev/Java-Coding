package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

	public static void main(String[] args) {
		String s1 = "abcabcbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s1));
        String s2 = "javavavaxyz";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s2));
        String s3 = "pwwkew";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s3));
	}

	private static int lengthOfLongestSubstring(String str) {
		
		int lengthOfLongestSubstringValue = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		char [] charArray = str.toCharArray();
		
		for(int i = 0; i < charArray.length ; i++) {
			char ch = charArray[i];
			if(!map.containsKey(ch)) { 
				map.put(ch, i); //a-0, b-1, c-2 //b-4, c-5
			}
			else {
				i = map.get(ch); //i = 4
				map.clear();
			}
			if(map.size() > lengthOfLongestSubstringValue) {
				lengthOfLongestSubstringValue = map.size();
			}
		}
		
		return lengthOfLongestSubstringValue;
	}

}
