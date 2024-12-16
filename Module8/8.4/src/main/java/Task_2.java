import java.util.Arrays;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) {
        // Input list of integers
        List<Integer> numbers = Arrays.asList(10, 5, 8, 20, 15, 3, 12);

        // Perform the functional operations
        int result = numbers.stream()
                .filter(num -> num % 2 != 0)  // Filter out even numbers
                .map(num -> num * 2)          // Double each remaining number
                .reduce(0, Integer::sum);     // Find the sum of resulting numbers

        // Print the result
        System.out.println("Sum of transformed numbers: " + result);
    }
}
