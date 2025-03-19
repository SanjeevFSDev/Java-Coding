package InterviewQuestions;

//INTERVIEW
public class RemoveUnwantedChars {
    public static void main(String[] args) {
        String[] arr = {"123f", "1dsa12", "121ds", "65fd", "sadfa", "asdasd"};
        int sum = 0;

        for (String str : arr) {
            String cleanedStr = str.replaceAll("[^0-9]", ""); // Remove non-numeric characters
            if (!cleanedStr.isEmpty()) {
                sum += Integer.parseInt(cleanedStr); // Convert to number and add to sum
            }
        }

        System.out.println("Sum of numbers: " + sum);
    }
}
