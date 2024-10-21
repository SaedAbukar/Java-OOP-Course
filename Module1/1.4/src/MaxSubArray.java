import java.util.Arrays;
import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = Integer.parseInt(reader.nextLine());
        int[] array = new int[size];
        System.out.println("Enter the integer into the array: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter Integer %d: ", i + 1);
            array[i] = Integer.parseInt(reader.nextLine());
        }
        System.out.println("The array is: " + Arrays.toString(array));

        int maxSum = array[0];
        int currentSum = array[0];
        int startIndex = 0;
        int endIndex = 0;
        int tempStartIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (currentSum + array[i] < array[i]) {
                currentSum = array[i];
                tempStartIndex = i;
            } else {
                currentSum += array[i];

            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = tempStartIndex;
                endIndex = i;
            }
        }
        System.out.printf("Maximum sum: %d %n", maxSum);
        System.out.printf("Integers: %d-%d", startIndex + 1, endIndex + 1);
    }
}
