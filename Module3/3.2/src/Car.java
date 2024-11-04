public class Car implements Vehicle {
    private String type;
    private String fuel;
    private String color;
    private boolean engine = false;

    public Car(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void getInfo() {
        System.out.println("Car Information:");
        System.out.printf("Type: %s%nFuel: %s%nColor: %s%n", type, fuel, color);
    }

    @Override
    public void start() {
        if (!engine) {
            engine = true;
            System.out.println("Car is starting...");
        }
    }

    @Override
    public void stop() {
        if (engine) {
            engine = false;
            System.out.println("Car is stopping...");
        }
    }
}
