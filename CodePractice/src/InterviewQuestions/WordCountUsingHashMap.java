package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class WordCountUsingHashMap {

	public static void main(String[] args) {
		
		String str = "java concept of the day java concept";
		
		String [] words = str.split("\\s+");
		
		Map<String, Integer> mapWordCount = new HashMap<>();
		
		for (String w : words) {
			if (mapWordCount.containsKey(w)) {
				int count = mapWordCount.get(w);
				mapWordCount.put(w, count+1);
			}
			else {
				mapWordCount.put(w, 1);
			}
		}
		
		mapWordCount.forEach((word, count) -> System.out.println(word + " : " + count));

	}

}
