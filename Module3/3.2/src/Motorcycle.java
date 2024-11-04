public class Motorcycle implements Vehicle {
    private String type;
    private String fuel;
    private String color;
    private boolean engine = false;

    public Motorcycle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void getInfo() {
        System.out.println("Motorcycle Information:");
        System.out.printf("Type: %s%nFuel: %s%nColor: %s%n", type, fuel, color);
    }

    @Override
    public void start() {
        if (!engine) {
            engine = true;
            System.out.println("Motorcycle is starting...");
        }
    }

    @Override
    public void stop() {
        if (engine) {
            engine = false;
            System.out.println("Motorcycle is stopping...");
        }
    }
}
