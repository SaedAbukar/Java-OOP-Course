public class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuel;
    protected String color;
    protected boolean engine = false;
    protected double price;
    protected double speed;
    protected double batteryCapacity;
    protected final int MAXBATTERYCAPACITY = 100;
    protected final int MINBATTERYCAPACITY = 0;
    protected double chargeSpeed;
    protected double range;


    public AbstractVehicle(String type, String fuel, String color, boolean engine, double price, double speed) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.engine = engine;
        this.price = price;
        this.speed = speed;
    }

    public AbstractVehicle(String type, String color, boolean engine, double price, double speed, double batteryCapacity, double chargeSpeed) {
        this.type = type;
        this.color = color;
        this.engine = engine;
        this.price = price;
        this.speed = speed;
        this.batteryCapacity = batteryCapacity;
        this.chargeSpeed = chargeSpeed;
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
        if (type.equals("Electric")) {
            System.out.printf("Type: %s%nBatterCapacity: %.2f%nRange: %.0f%nCharging speed: %.0f%nColor: %s%n", type, batteryCapacity, range, chargeSpeed, color);
        } else {
            System.out.printf("Type: %s%nFuel: %s%nColor: %s%n", type, fuel, color);
        }
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

    public void charge() {
        if (!type.equals("Electric")) {
            System.out.println("Not possible to charge");
        } else {
            System.out.println("Charging...");
        }
    }
}
