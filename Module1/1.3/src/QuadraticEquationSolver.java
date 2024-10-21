import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter the coefficients of quadratic equation: ");
        System.out.println("Enter the coefficient a: ");
        double a = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the coefficient b: ");
        double b = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the coefficient c: ");
        double c = Integer.parseInt(scan.nextLine());

        double d = Math.sqrt(b * b - 4 * a * c);

        if (d > 0.0) {
            double x = (-b + d) / 2 * a;
            double y = (-b - d) / 2 * a;
            System.out.println("The root of the quadratic equation is " + x + ", " + y);
        } else if (d == 0.0) {
            double x = -b / 2 * a;
            System.out.println("The root of the quadratic equation is " + x);
        } else {
            System.out.println("Roots are not real");
        }


    }
}
