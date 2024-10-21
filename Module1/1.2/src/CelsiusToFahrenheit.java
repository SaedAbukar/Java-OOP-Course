import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the degree in fahrenheit:");
        double deg = Double.parseDouble(reader.nextLine());

        double celsius = (deg - 32) * 5 / 9;

        System.out.printf("The degree in celsius is %.1fC", celsius);
    }
}