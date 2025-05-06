package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RunLengthEncoding {

	public static void main(String[] args) {
		String input = "aabbbccaaa";
        String result = encodeConsecutive(input);
        System.out.println(result); // Output: a2b3c2a3

	}
	
	private static String encodeConsecutive(String str) {
		if(str == null || str.isBlank()) return "";
		
		List<CharGroup> group = new ArrayList<>();
		
		char[] charArray = str.toCharArray();
		
		char prev = charArray[0];
		int count = 1;
		
		for(int i=0; i<charArray.length; i++) {
			if(charArray[i] == prev) {
				count++;	
			}
			else {
				group.add(new CharGroup(prev, count));
				prev = charArray[i];
				count = 1;
			}
		}
		group.add(new CharGroup(prev, count));
		
		return group.stream().map(groups -> groups.ch + String.valueOf(groups.count)).collect(Collectors.joining());
		
	}
	
	static class CharGroup{
		char ch;
		int count;
		
		CharGroup(char ch, int count){
			this.ch = ch;
			this.count = count;
		}
	}

}
