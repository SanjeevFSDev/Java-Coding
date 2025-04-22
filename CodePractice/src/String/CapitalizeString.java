package String;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CapitalizeString {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the String : ");
		String str = "i love my country so   much";
			
		String [] word = str.split(" ");
		String capitalizeString = "";
		
		for (String w : word) {
			System.out.println(w);
			if(!w.isEmpty()) {
				String first = w.substring(0,1);
				String afterFisrt = w.substring(1);
				
				capitalizeString += first.toUpperCase() + afterFisrt + " ";
			}
		}
		System.out.println("Final String is: " +capitalizeString.trim());
		
		//By Using Stream API
		String capitalized = Arrays.stream(str.trim().split("\\s+"))
                .map(words -> Character.toUpperCase(words.charAt(0)) + words.substring(1))
                .collect(Collectors.joining(" "));

        System.out.println(capitalized);
	}	
}
