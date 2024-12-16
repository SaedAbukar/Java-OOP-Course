import java.util.ArrayList;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) {
        // Step 1: Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        // Step 2: Filter out even numbers
        numbers.removeIf(num -> num % 2 == 0);

        // Print the list after filtering
        System.out.println("After removing even numbers:");
        numbers.forEach(System.out::println);

        // Step 3: Double the value of odd numbers
        numbers.replaceAll(num -> num * 2);

        // Print the list after doubling
        System.out.println("\nAfter doubling odd numbers:");
        numbers.forEach(System.out::println);

        // Step 4: Calculate the sum of all numbers
        int sum = numbers.stream().mapToInt(Integer::intValue).sum(); // Lambda for summing
        System.out.println("\nSum of numbers: " + sum);
    }
}
