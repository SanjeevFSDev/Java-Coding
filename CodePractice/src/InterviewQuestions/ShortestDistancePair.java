package InterviewQuestions;

import java.util.Arrays;

//INTERVIEW
public class ShortestDistancePair {
    public static void main(String[] args) {
        int[] arr = {3, 6, 13, 91, 22, 92, 28};

        // Step 1: Sort the array
        Arrays.sort(arr); // arr = {3, 6, 13, 22, 28, 91, 92}

        // Step 2: Find the pair with the minimum difference
        int minDiff = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];  // Difference between adjacent elements
            if (diff < minDiff) {
                minDiff = diff;
                num1 = arr[i];
                num2 = arr[i + 1];
            }
        }

        // Step 3: Print the pair with the shortest distance
        System.out.println("The two numbers with the shortest distance are: " + num1 + " and " + num2);
    }
}
