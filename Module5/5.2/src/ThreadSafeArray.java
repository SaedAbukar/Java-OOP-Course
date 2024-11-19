import java.util.ArrayList;

public class ThreadSafeArray {
    private ArrayList<Integer> threadSafeArray;

    public ThreadSafeArray() {
        threadSafeArray = new ArrayList<>();
    }

    public void add(Integer i) {
        synchronized (this) {
            threadSafeArray.add(i);
        }
    }

    public int size() {
        synchronized (this) {
            return threadSafeArray.size();
        }
    }

    public Integer remove(Integer i) {
        boolean found = false;
        synchronized (this) {
            found = threadSafeArray.remove(i);
        }
        return found ? i : null;
    }

    public ArrayList<Integer> getThreadSafeArray() {
        return threadSafeArray;
    }

    public static void main(String[] args) {
        ThreadSafeArray threadSafeArray = new ThreadSafeArray();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int capturedValue = i;
            Thread threadAdder = new Thread(() -> threadSafeArray.add(capturedValue));
            threads.add(threadAdder);
            threadAdder.start();
        }

        System.out.println(threadSafeArray.size());

        for (int i = 0; i < 100; i++) {
            int capturedValue = i;
            Thread threadRemover = new Thread(() -> threadSafeArray.remove(capturedValue));
            threads.add(threadRemover);
            threadRemover.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadSafeArray.size());
    }
}
