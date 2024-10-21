import java.util.Random;
import java.util.Scanner;

public class MultiplicationTableExam {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int total = 10;

        int i = 0;
        int correct = 0;
        int wrong = 0;
        while (i < total) {
            int randomNumber1 = rand.nextInt(10);
            int randomNumber2 = rand.nextInt(10);
            System.out.println("What is " + randomNumber1 + " * " + randomNumber2 + "?");
            int answer = Integer.parseInt(scan.nextLine());
            if (answer == (randomNumber1 * randomNumber2)) {
                correct++;
            } else {
                wrong++;
            }
            i++;
            System.out.println("Correct: " + correct + ", Wrong: " + wrong);
            if (correct == total) {
                System.out.println("Congrats! You got every question correct!");
                break;
            }
            if (i == total) {
                System.out.println("Your result was: " + correct + " times and " + wrong + " times.");
            }
        }
    }
}