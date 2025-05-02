package Array;

import java.util.Arrays;
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
		
		System.out.println();
		
		//By Using Stream API
		int[] reversed = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .toArray();

        System.out.println(Arrays.toString(reversed));
        
     /* Step-by-step explanation
        1. IntStream.range(0, arr.length)
        This creates a stream of integers from 0 to arr.length - 1.

        For example, if arr.length == 5, this will generate: 0, 1, 2, 3, 4.

        2. .map(i -> arr[arr.length - 1 - i])
        For each index i from the stream, it maps it to the element at the reversed index in the original array.

        arr.length - 1 - i calculates the index from the end of the array.

        When i = 0, we get arr[4]

        When i = 1, we get arr[3]

        ...

        When i = 4, we get arr[0]

        So, this effectively reverses the array.

        3. .toArray()
        Collects the mapped values into a new int[] array.

        4. System.out.println(Arrays.toString(reversed))
        Prints the reversed array in a readable format like [5, 4, 3, 2, 1] 
        
        Example
		If arr = {1, 2, 3, 4, 5}, then:
		
		IntStream.range(0, 5) gives: 0, 1, 2, 3, 4
		
		Mapping each:
		
		i = 0 → arr[4] = 5
		
		i = 1 → arr[3] = 4
		
		i = 2 → arr[2] = 3
		
		i = 3 → arr[1] = 2
		
		i = 4 → arr[0] = 1
		
		New array: {5, 4, 3, 2, 1}*/

	}

}
