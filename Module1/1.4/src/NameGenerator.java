import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        String[] lastnames = {"Abukar", "James", "Curry", "Messi", "Ronaldo"};
        String[] firstnames = {"Saed", "Lebron", "Steph", "Lionel", "Cristiano"};

        Scanner reader = new Scanner(System.in);
        Random random = new Random();

        int i = 0;
        System.out.print("Enter the amount of time to generate a random name between 0-4: ");
        int time = Integer.parseInt(reader.nextLine());
        if (time > 4 || time < 0) {
            time = 4;
            System.out.println("You entered a number that is outside the range. Your number was capped to four");
        }

        while (i < time) {
            int boundary1 = random.nextInt(time) + 1;
            int boundary2 = random.nextInt(time) + 1;
            System.out.println("Random name is " + firstnames[boundary1] + " " + lastnames[boundary2]);
            i++;
        }
    }
}