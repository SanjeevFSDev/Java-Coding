package String;

public class CapitalizeString {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the String : ");
		String str = "i love my country so much";
			
		String [] word = str.split(" ");
		String capitalizeString = "";
		
		for (String w : word) {
			System.out.println(w);
			String first = w.substring(0,1);
			String afterFisrt = w.substring(1);
			
			capitalizeString += first.toUpperCase() + afterFisrt + " ";
			
		}
		System.out.println("Final String is: " +capitalizeString.trim());
		
//		for(int i=0; i<str.length(); i++){
//			char word = str.charAt(0);
//			newString += Character.toUpperCase(word) + str.substring(1) + "";
//		}
//		
//		System.out.println(newString);
	}	
}
