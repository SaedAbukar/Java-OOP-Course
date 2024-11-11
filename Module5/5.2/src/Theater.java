public class Theater {
    private static final int numberOfSeats = 10;
    private static int tickets = 0;

    public int getTickets() {
        return tickets;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public synchronized boolean reserveTicket(int amount) {
        if (amount <= numberOfSeats - tickets) {
            tickets += amount;
            return true;
        } else {
            return false;
        }
    }
}
