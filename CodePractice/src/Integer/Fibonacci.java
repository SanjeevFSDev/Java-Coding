package Integer;

public class Fibonacci  {
	
	private static int getFibonacci(int num) {
		if(num <= 1) {
			return num;
		}
		return getFibonacci(num-1) + getFibonacci(num-2);
	}

	public static void main(String[] args) {
		int N = 7;
		//For printing Fibonacci series
		for(int i = 0; i <= N; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
		
		System.out.println("Fibonacci value: "+getFibonacci(1));
	}

}
