package InterviewQuestions;

public class LongestRepeatedSubstring {
    public static void main(String[] args) {
        String str = "SanjeevSanjeev".toLowerCase();
        int len = str.length();

        String longestRepeatedSubstring = "";
        int maxLength = 0;

        // Compare all substrings
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String sub = str.substring(i, j);

                // Skip full string and shorter than current max
                if (sub.length() <= maxLength || sub.length() == len) {
                    continue;
                }

                // Check if this substring appears elsewhere
                int firstIndex = str.indexOf(sub);
                int lastIndex = str.lastIndexOf(sub);

                if (firstIndex != lastIndex) {
                    longestRepeatedSubstring = sub;
                    maxLength = sub.length();
                }
            }
        }

        if (!longestRepeatedSubstring.isEmpty()) {
            System.out.println("Longest repeated substring: \"" + longestRepeatedSubstring + "\"");
        } else {
            System.out.println("No repeated substrings found.");
        }
    }
}


