import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the first positive number: ");
        int number1 = Integer.parseInt(reader.nextLine());
        System.out.print("Enter the second positive number: ");
        int number2 = Integer.parseInt(reader.nextLine());

        if (number1 < 2) {
            number1 = 2;
        }
        for (int i = number1; i < number2; i++) {
            if (i > 2 && i % 2 == 0) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }

        }
    }
}