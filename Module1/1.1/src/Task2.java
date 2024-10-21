public class Task2 {
    public static void main(String[] args) {
        int n = 4; // Number of rows

        // Outer loop for each row
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print asterisks
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // Move to the next line after printing one row
            System.out.println();
        }
    }
}
