package String;

public class SwapStrings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World everyone";

        // Swapping the strings without a temporary variable
        str1 = str1 + str2;  // Concatenate both strings HelloWorld everyone
        str2 = str1.substring(0, str1.length() - str2.length()); // Extract the original str1
        str1 = str1.substring(str2.length()); // Extract the original str2

        // Output the swapped values
        System.out.println("After swapping:");
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}

