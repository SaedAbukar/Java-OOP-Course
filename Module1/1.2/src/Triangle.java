import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the side A of the right triangle: ");
        int sideA = reader.nextInt();
        System.out.print("Enter the side B of the right triangle: ");
        int sideB = reader.nextInt();
        int hypotenuse = sideA * sideB;

        System.out.println("The hypotenuse of the triangle is " + hypotenuse);
    }
}
