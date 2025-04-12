package InterviewQuestions;

import java.util.Arrays;

public class EqualArrays {
	
	public static void main(String[] args) {
		
		String[] a = {"Java", "Spring", "Angular"};
		String[] b = {"Java", "Spring", "Angular"};
		String[] c = {"Java", "Angular", "Spring"};
		String[] d = {"Java", "Spring", "Angular"};
		String[] e = {"Java", "Angular", "Spring"};
		String[] f = {"Java", "Spring", "ReactJs"};
		String[] g = {"Java", "Angular", "Spring"};
		String[] h = {"Java", "Spring", "ReactJs", "Angular"};
		String[] i = null;
		String[] j = null;
		String[] k = {"Java", "Spring", "ReactJs", "Angular"};
		String[] l = null;
		System.out.println(areArraysEqual(a, b)); // Output: true
		System.out.println(areArraysEqual(c, d)); // Output: true
		System.out.println(areArraysEqual(e, f)); // Output: false
		System.out.println(areArraysEqual(g, h)); // Output: false
		System.out.println(areArraysEqual(i, j)); // Output: true
		System.out.println(areArraysEqual(k, l)); // Output: false
	}
	
	public static boolean areArraysEqual(String[] array1, String[] array2) {
	    if (array1 == null && array2 == null) return true;
	    if (array1 == null || array2 == null) return false;
	    if (array1.length != array2.length) return false;

	    // Sort both arrays
	    String[] sortedArray1 = array1.clone(); // Creates a new array with the same values
	    String[] sortedArray2 = array2.clone(); 
	    Arrays.sort(sortedArray1); // Sorts the copy, not the original
	    Arrays.sort(sortedArray2);

	    // Compare elements
	    for (int i = 0; i < sortedArray1.length; i++) {
	        if (!sortedArray1[i].equals(sortedArray2[i])) {
	            return false;
	        }
	    }

	    return true;
	}
}
