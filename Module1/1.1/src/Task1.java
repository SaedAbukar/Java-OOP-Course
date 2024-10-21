import java.util.Scanner;  // Import the Scanner class

public class Task1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter username");

        String username = input.nextLine();
        System.out.println("Hello " + username);
    }
}
