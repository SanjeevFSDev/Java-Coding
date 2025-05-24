package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCountUsingHasMap {

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
		
		//To convert output from {a=2, s=2, t=4, e=2, v=1, g=1, i=1, j=1, n=1} to {a:2,s:2,t:4,e:2,v:1,g:1,i:1,j:1,n:1}
		String result = charMap.entrySet().stream()
		        .map(entry -> entry.getKey() + ":" + entry.getValue())
		        .collect(Collectors.joining(",", "{", "}"));
		
		//OR
		System.out.println(charMap.toString().replace("=", ":"));
		
		System.out.println(result);
		
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
