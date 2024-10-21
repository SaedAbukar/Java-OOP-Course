import java.util.Scanner;

public class RemovingDuplicates {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = Integer.parseInt(reader.nextLine());
        int[] array = new int[size];
        System.out.println("The integers into the array: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            array[i] = Integer.parseInt(reader.nextLine());
        }
        int[] array2 = new int[size];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (array[i] == array2[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                array2[count] = array[i];
                count++;
            }
        }
        System.out.println("The array without duplicates:");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d ", array2[i]);
        }
    }
}
