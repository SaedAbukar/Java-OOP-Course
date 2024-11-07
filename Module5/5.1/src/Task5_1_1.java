import java.util.Scanner;

public class Task5_1_1 {
    public static void main(String[] args) {
        int response = 0;
        int start = 0;
        int end = 0;
        boolean correct = true;

        Scanner input = new Scanner(System.in);

        while (correct) {
            try {
                System.out.println("Enter the starting number: ");
                start = Integer.parseInt(input.nextLine());
                System.out.println("Enter the ending number: ");
                end = Integer.parseInt(input.nextLine());
                /*response = Integer.parseInt(input.nextLine());*/
                correct = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter a number please");
            }
        }

        NumberPrinter printer = new NumberPrinter(start, end, "Even");
        NumberPrinter printer2 = new NumberPrinter(start, end, "Odd");
        Thread thread = new Thread(printer);
        Thread thread2 = new Thread(printer2);
        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Printing complete.");
    }
}
