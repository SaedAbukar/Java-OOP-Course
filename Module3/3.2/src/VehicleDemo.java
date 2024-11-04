public class VehicleDemo {
    public static void main(String[] args) {
        AbstractVehicle car = new Car("Car", "Petrol", "Red", false, 10000, 100);
        AbstractVehicle motorcycle = new Motorcycle("Motorcycle", "Gasoline", "Black", false, 5000, 70);
        AbstractVehicle bus = new Bus("Bus", "Blue", "Diesel", false, 40, 20000, 60);

        AbstractVehicle[] vehicles = {car, motorcycle, bus};

        for (AbstractVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.getInfo();
            System.out.printf("The price is: %.0f€%n", vehicle.getPrice());
            System.out.printf("The speed is: %.2fkm/h%n", vehicle.getSpeed());
        }
    }
}
