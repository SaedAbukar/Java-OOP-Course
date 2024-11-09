import java.util.Arrays;
import java.util.Random;

public class Task5_1_2 {
    public static void main(String[] args) {
        int[] array = new int[100000];
        Random rand = new Random();
        int totalSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(array.length);
        }

        int processors = Runtime.getRuntime().availableProcessors();
        int subArrayAmount = array.length / processors;
        int[][] subarrays = new int[subArrayAmount][];

        for (int i = 0; i < processors; i++) {
            int start = i * subArrayAmount;
            int end = Math.min(start + subArrayAmount, array.length);
            subarrays[i] = Arrays.copyOfRange(array, start, end);
        }
        ArraySum[] subarrayReferences = new ArraySum[processors];
        Thread[] threadReferences = new Thread[processors];
        double startTime = System.nanoTime();
        for (int i = 0; i < processors; i++) {
            ArraySum arraySum = new ArraySum(subarrays[i]);
            Thread thread = new Thread(arraySum);
            subarrayReferences[i] = arraySum;
            threadReferences[i] = thread;
            thread.start();
        }

        for (int i = 0; i < processors; i++) {
            try {
                threadReferences[i].join();
                totalSum += subarrayReferences[i].getSum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        double endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("The system has " + processors + " processors cores");
        System.out.println("Total time elapsed: " + totalTime + " nanoseconds");
        System.out.println("The total sum is: " + totalSum);
    }
}
