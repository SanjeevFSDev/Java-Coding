package Integer;

public class PalindromenNumber {
	
	private static void checkPalindromNumber(int num) {
		int temp=num;
		int sum = 0;
		
		while(num>0) {
			int r = num%10;
			sum = sum*10 + r;
			num = num/10;
		}
		if(temp == sum) {
			System.out.println(temp + " is a Palindrom Number");
		}
		else {
			System.out.println(temp + " is NOT a Palindrom Number");
		}
		
	}

	public static void main(String[] args) {
		checkPalindromNumber(121);
		checkPalindromNumber(1221);
		checkPalindromNumber(1931);

	}

}
