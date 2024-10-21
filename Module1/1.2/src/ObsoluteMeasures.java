import java.util.Scanner;

public class ObsoluteMeasures {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the weight in grams: ");
        float gram = Float.parseFloat(reader.nextLine());

        float luoti = 13.28f;
        float naula = 32 * luoti;
        float leiviska = 20 * naula;

        int totalLeiviska = (int) (gram / leiviska);
        gram %= leiviska;

        int totalNaula = (int) (gram / naula);
        gram %= naula;

        float totalLuoti = gram / luoti;


        System.out.printf("The weight in leiviska is: %d, ", totalLeiviska);
        System.out.printf("The weight in naula is: %d, ", totalNaula);
        System.out.printf("The weight in luoti is: %.2f, ", totalLuoti);
    }
}