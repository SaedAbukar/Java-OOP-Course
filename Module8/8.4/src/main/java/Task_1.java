import java.util.Arrays;

public class Task_1 {
    public static void main(String[] args) {
        // Input array
        int[] numbers = {10, 20, 30, 40, 50};

        // Calculate mean using streams
        double mean = Arrays.stream(numbers) // Convert array to IntStream
                .average()       // Find the average
                .orElse(0.0);    // Default to 0.0 if empty

        // Print the mean
        System.out.println("Mean: " + mean);
    }
}
