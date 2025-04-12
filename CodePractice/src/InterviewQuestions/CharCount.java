package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class CharCount {

	public static void getCharCount(String name) {
		Map<Character, Integer> charMap = new HashMap<>();
		
		char[] chArray = name.toCharArray();
		for(char ch : chArray) {
			if(!String.valueOf(ch).isBlank()) {
				if(charMap.containsKey(ch)) {
					int count = charMap.get(ch);
					charMap.put(ch, count + 1);
				}
				else {
					charMap.put(ch, 1);
				}
			}
		}
		
		System.out.println(name + " : " + charMap);
		
		//If Interviewer ask to print char more than 1
		for(Map.Entry<Character, Integer> mapEntry : charMap.entrySet()) {
			if(mapEntry.getValue() > 1) {
				System.out.println(mapEntry.getKey() + " : " + mapEntry.getValue());
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		getCharCount("testing java test  ");

	}

}
