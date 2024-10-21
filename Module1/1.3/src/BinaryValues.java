import java.util.Scanner;

public class BinaryValues {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter Binary Value: ");
        String binaryValue = reader.nextLine();
        double decimal = 0;

        for (int i = 0; i < binaryValue.length(); i++) {
            char c = binaryValue.charAt(i);
            System.out.println("The char is: " + c);
            double val = Integer.parseInt(String.valueOf(c)) * Math.pow(2, binaryValue.length() - i - 1);
            decimal += val;

        }
        System.out.println("Decimal Value: " + decimal);
    }
}
