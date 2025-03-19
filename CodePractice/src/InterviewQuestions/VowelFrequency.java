package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class VowelFrequency {
	
	public static Map<Character, Integer> getVowelCount(String name) {
		Map<Character, Integer> vowelMap = new HashMap<>();
		
		String lowerCaseName = name.toLowerCase();
		
		String vowels = "aeiou";
		
		char[] chArray = lowerCaseName.toCharArray();
		for(char ch : chArray) {
			if(!String.valueOf(ch).isBlank()) {
				if(vowels.indexOf(ch) != -1) {
					int count = vowelMap.getOrDefault(ch, 0);
					vowelMap.put(ch, count + 1);
				}
			}
		}
		return vowelMap;
	}

	public static void main(String[] args) {
		
		Map<Character, Integer> vowelFrequency = getVowelCount("My name is Sanjeev");
		System.out.println(vowelFrequency);
		
//		for(Map.Entry<Character, Integer> mapEntry : vowelFrequency.entrySet()) {
//			System.out.println(mapEntry.getKey() + " : " + mapEntry.getValue());
//		}
		
	}

}
