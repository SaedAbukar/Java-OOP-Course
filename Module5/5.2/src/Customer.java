import java.util.ArrayList;

public class Customer implements Runnable {
    private static int increment = 1;
    private final int id;
    private final Theater theater;
    private final ArrayList<Integer> tickets;
    private final int reservationAmount;
    private String reservationStatus;

    public Customer(Theater theater, int reservationAmount) {
        this.id = increment++;
        this.theater = theater;
        this.tickets = new ArrayList<>();
        this.reservationAmount = reservationAmount;
        this.reservationStatus = "";
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getTickets() {
        return tickets;
    }

    public int getReservationAmount() {
        return reservationAmount;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void run() {
        if (theater.reserveTicket(reservationAmount)) {
            reservationStatus = "reserved " + reservationAmount + " tickets";
        } else {
            reservationStatus = "couldn't reserve " + reservationAmount + " tickets";
        }
    }
}
