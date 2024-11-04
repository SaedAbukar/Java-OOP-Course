public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String type, String color, String fuel, Boolean engine, int capacity, double price, double speed, double fuelEfficiency) {
        super(type, fuel, color, engine, price, speed, fuelEfficiency);
        this.capacity = capacity;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("Capacity: %d passengers%n", capacity);
    }
}
