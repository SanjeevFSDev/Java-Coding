package InterviewQuestions;

import java.util.Arrays;

public class LongestRepeatedSubstring {
	public static void main(String[] args) {
        String str = "SanjeevSanjeev".toLowerCase();
        int n = str.length();

        // Step 1: Build all suffixes
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = str.substring(i);
        }

        // Step 2: Sort the suffixes
        Arrays.sort(suffixes);

        // Step 3: Find the Longest Common Prefix (LCP) between adjacent suffixes
        String longest = "";
        for (int i = 0; i < n - 1; i++) {
            String lcp = commonPrefix(suffixes[i], suffixes[i + 1]);
            if (lcp.length() > longest.length()) {
                longest = lcp;
            }
        }

        if (!longest.isEmpty()) {
            System.out.println("Longest repeated substring: \"" + longest + "\"");
        } else {
            System.out.println("No repeated substrings found.");
        }
    }

    // Helper method to find longest common prefix of two strings
    private static String commonPrefix(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.substring(0, i);
            }
        }
        return a.substring(0, minLength);
    }
//    public static void main(String[] args) {
//        String str = "SanjeevSanjeev".toLowerCase();
//        int len = str.length();
//
//        String longestRepeatedSubstring = "";
//        int maxLength = 0;
//
//        // Compare all substrings
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j <= len; j++) {
//                String sub = str.substring(i, j);
//
//                // Skip full string and shorter than current max
//                if (sub.length() <= maxLength || sub.length() == len) {
//                    continue;
//                }
//
//                // Check if this substring appears elsewhere
//                int firstIndex = str.indexOf(sub);
//                int lastIndex = str.lastIndexOf(sub);
//
//                if (firstIndex != lastIndex) {
//                    longestRepeatedSubstring = sub;
//                    maxLength = sub.length();
//                }
//            }
//        }
//
//        if (!longestRepeatedSubstring.isEmpty()) {
//            System.out.println("Longest repeated substring: \"" + longestRepeatedSubstring + "\"");
//        } else {
//            System.out.println("No repeated substrings found.");
//        }
//    }
}


