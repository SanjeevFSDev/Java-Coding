package Integer;

public class Factorial {
	
	private static int getFactorial(int num) {
		
		if(num == 0) {
			return 1;
		}
		return num*getFactorial(num-1);
	}

	public static void main(String[] args) {
	
		int getFactorialValue = getFactorial(5);
		System.out.println(getFactorialValue);

	}

}
