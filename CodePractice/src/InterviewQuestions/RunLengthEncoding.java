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
		
		List<CharGroup> groupList = new ArrayList<>();
		
		char[] charArray = str.toCharArray();
		
		char prev = charArray[0];
		int count = 1;
		
		for(int i=1; i<charArray.length; i++) {
			if(charArray[i] == prev) {
				count++;	
			}
			else {
				groupList.add(new CharGroup(prev, count));
				prev = charArray[i];
				count = 1;
			}
		}
		groupList.add(new CharGroup(prev, count));
		
		return groupList.stream().map(group -> group.ch + String.valueOf(group.count)).collect(Collectors.joining());
		
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
