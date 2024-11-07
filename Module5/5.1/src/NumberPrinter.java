public class NumberPrinter implements Runnable {
    private int amount;
    private String name;
    private int start;
    private int end;

    public NumberPrinter(int start, int end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
    }

    @Override
    public void run() {
        if (name.equals("Even") && start % 2 == 1) {
            start++;
        } else if (name.equals("Odd") && start % 2 == 0) {
            start++;
        }

        for (int i = start; i <= end; i += 2) {
            System.out.printf("%s Thread: %d%n", name, i);
        }
    }
}