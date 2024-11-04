public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    private String type;
    private String fuel;
    private String color;
    private boolean engine = false;
    private double price;
    private double speed;
    private double batteryCapacity;
    private final int MAXBATTERYCAPACITY = 100;
    private final int MINBATTERYCAPACITY = 0;
    private double chargeSpeed;
    private double range;
    private double fuelEfficiency;
    private double batteryEfficiency;


    public AbstractVehicle(String type, String fuel, String color, boolean engine, double price, double speed, double fuelEfficiency) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.engine = engine;
        this.price = price;
        this.speed = speed;
        this.fuelEfficiency = fuelEfficiency;
    }

    public AbstractVehicle(String type, String fuel, String color, boolean engine, double price, double speed, double batteryCapacity, double chargeSpeed, double batteryEfficiency) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.engine = engine;
        this.price = price;
        this.speed = speed;
        this.batteryCapacity = batteryCapacity;
        this.chargeSpeed = chargeSpeed;
        this.batteryEfficiency = batteryEfficiency;
    }

    public double getPrice() {
        return price;
    }

    public double getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public String getFuel() {
        return fuel;
    }

    @Override
    public void getInfo() {
        System.out.printf("%s Information%n", type);
        if (fuel.equals("Electric")) {
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
        if (!fuel.equals("Electric")) {
            System.out.println("Not possible to charge");
        } else {
            System.out.println("Charging...");
        }
    }

    public double calculateFuelEfficiency() {
        if (fuel.equals("Electric")) {
            return batteryEfficiency;
        } else {
            return fuelEfficiency;
        }
    }
}
