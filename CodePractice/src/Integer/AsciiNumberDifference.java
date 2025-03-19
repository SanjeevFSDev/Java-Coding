package Integer;

//INTERVIEW
public class AsciiNumberDifference {
	
	private static int getAsciiSum(String str) {
		int sum=0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			sum = sum + ch;
		}
		return sum;
	}

	public static void main(String[] args) {
		
		String str1 = "123ABC";
		String str2 = "456DEF";
		
		int num1 = getAsciiSum(str1);
		int num2 = getAsciiSum(str2);
		System.out.println(num1 + " and " + num2);
		
		int difference = num1 - num2;
		
		System.out.println(difference);

	}

}
