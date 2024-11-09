public class ArraySum implements Runnable {

    private int[] array;
    private int sum;

    public ArraySum(int[] array) {
        this.array = array;
    }

    public int getSum() {
        return sum;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
    }

}
