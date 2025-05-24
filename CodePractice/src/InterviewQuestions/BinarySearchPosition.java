package InterviewQuestions;

//INTERVIEW
public class BinarySearchPosition  {
    public static int binarySearch(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid index
            System.out.println(mid);
            if (arr[mid] == k) {
                return mid + 1; // Return position (1-based index)
            } else if (arr[mid] < k) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int position = binarySearch(arr, k);

        if (position != -1) {
            System.out.println("Element " + k + " is at position: " + position);
        } else {
            System.out.println("Element not found");
        }
    }
}
