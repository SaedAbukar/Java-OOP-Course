import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task5_2_1 {

    static final int CUSTOMERS = 13;

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        Theater theater = new Theater();
        Random rand = new Random(123);
        for (int i = 0; i < CUSTOMERS; i++) {
            int reservationAmount = rand.nextInt(1, 4);
            Customer c = new Customer(theater, reservationAmount);
            customers.add(c);
            Thread t = new Thread(c);
            threads.add(t);
            t.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (Customer customer : customers) {
            System.out.printf("Customer %d %s.%n", customer.getId(), customer.getReservationStatus());
        }

        System.out.println("Total tickets reserved: " + theater.getTickets());
        System.out.println("Total seats available: " + theater.getNumberOfSeats());
    }
}