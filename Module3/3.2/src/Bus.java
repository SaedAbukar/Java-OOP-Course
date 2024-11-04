public class Bus implements Vehicle {
    private String type;
    private String fuel;
    private int capacity;
    private boolean engine = false;

    public Bus(String type, String fuel, int capacity) {
        this.type = type;
        this.fuel = fuel;
        this.capacity = capacity;
    }

    @Override
    public void getInfo() {
        System.out.println("Bus Information:");
        System.out.printf("Type: %s%nFuel: %s%nCapacity: %d passengers%n", type, fuel, capacity);
    }

    @Override
    public void start() {
        if (!engine) {
            engine = true;
            System.out.println("Bus is starting...");
        }
    }

    @Override
    public void stop() {
        if (engine) {
            engine = false;
            System.out.println("Bus is stopping...");
        }
    }
}
