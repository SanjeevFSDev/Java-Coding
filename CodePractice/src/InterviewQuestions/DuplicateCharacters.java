package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {

	public static void main(String[] args) {
		
		String str = "I am Sanjeev Prasad";
		str = str.toLowerCase().replaceAll("\\s+", "");
		char ch;
		
		HashMap<Character, Integer> hashMap = new HashMap<>();
		
		for(int i=0 ; i<str.length(); i++) {
			ch = str.charAt(i);
			if(hashMap.containsKey(ch)) {
				int count = hashMap.get(ch);
				hashMap.put(ch, count + 1);
			}
			else {
				hashMap.put(ch, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> mapEntry : hashMap.entrySet()) {
			
			System.out.println(mapEntry.getKey() + " : " + mapEntry.getValue());
			
		}

	}

}
