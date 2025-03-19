package Array;
public class FindElementByIndex {

    // Method to get the element at a given index
    public static int findElementAtIndex(int[] arr, int index) {
        // Check if the index is within the array's bounds
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return arr[index];
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int index = 4; // Example index

        try {
            int element = findElementAtIndex(array, index);
            System.out.println("Element at index " + index + " is: " + element);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
