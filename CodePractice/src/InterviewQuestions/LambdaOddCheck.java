package InterviewQuestions;

import java.util.function.Predicate;

public class LambdaOddCheck {
    public static Predicate<Integer> isOdd() {
        return num -> num % 2 != 0; // Returns true if odd, false if even
    }

    public static void main(String[] args) {
        Predicate<Integer> checkOdd = isOdd();

        System.out.println(checkOdd.test(5)); // Output: true (odd)
        System.out.println(checkOdd.test(10)); // Output: false (even)
    }
}
