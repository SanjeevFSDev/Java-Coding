package InterviewQuestions;

public class PrimeNumbers {

	public static void main(String[] args) {
		int[] numbers = new int[100];

        // Fill the array with numbers from 1 to 100
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }

        findPrimeNumbers(numbers);
    }    

    private static void findPrimeNumbers(int[] numbers) {
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.println(num + " is a prime number.");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
