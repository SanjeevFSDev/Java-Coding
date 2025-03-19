package Array;

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

	}

}
