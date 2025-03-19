package Array;

public class FindElementPosition {

    // Method to find the position of element k in the array
    public static int findElementPosition(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i; // Return the index when element is found
            }
        }
        return -1; // Element not found in the array
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int k = 30;
        
        int position = findElementPosition(array, k);
        if (position != -1) {
            System.out.println("Element " + k + " is found at index " + position);
        } else {
            System.out.println("Element " + k + " is not found in the array.");
        }
    }
}

