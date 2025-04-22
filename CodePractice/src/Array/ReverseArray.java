package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ReverseArray {
	
	private static void reverse(int[] arr) {
		int i=0; 
		int j = arr.length-1;
		
		while(i<=j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {45, 78, 4, 7 , 9, 10};
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		
		reverse(arr);
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
		//By Using Stream API
		int[] reversed = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .toArray();

        System.out.println(Arrays.toString(reversed));

	}

}
