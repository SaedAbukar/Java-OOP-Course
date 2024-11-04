public class AbstractVehicle implements Vehicle {
    protected String type;
    protected String fuel;
    protected String color;
    protected boolean engine = false;
    protected double price;
    protected double speed;

    public AbstractVehicle(String type, String fuel, String color, boolean engine, double price, double speed) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.engine = engine;
        this.price = price;
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public void getInfo() {
        System.out.printf("%s Information%n", type);
        System.out.printf("Type: %s%nFuel: %s%nColor: %s%n", type, fuel, color);
    }

    @Override
    public void start() {
        if (!engine) {
            engine = true;
            System.out.printf("%s is starting...%n", type);
        }
    }

    @Override
    public void stop() {
        if (engine) {
            engine = false;
            System.out.printf("%s is stopping...%n", type);
        }
    }
}
