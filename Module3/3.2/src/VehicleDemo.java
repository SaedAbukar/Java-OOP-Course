public class VehicleDemo {
    public static void main(String[] args) {
        AbstractVehicle car = new Car("Car", "Petrol", "Red", false, 10000, 100, 7);
        AbstractVehicle motorcycle = new Motorcycle("Motorcycle", "Gasoline", "Black", false, 5000, 70, 5);
        AbstractVehicle bus = new Bus("Bus", "Blue", "Diesel", false, 40, 20000, 60, 13);
        AbstractVehicle electricCar = new ElectricCar("Car", "Electric", "Yellow", false, 30000, 120, 50, 5, 12);
        AbstractVehicle electricMotorcycle = new ElectricMotorcycle("Motorcycle", "Electric", "Gold", false, 70000, 330, 20, 5, 13);

        AbstractVehicle[] vehicles = {car, motorcycle, bus, electricCar, electricMotorcycle};

        for (AbstractVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.getInfo();
            vehicle.charge();
            String fuel = vehicle.getFuel();
            if (fuel.equals("Electric")) {
                System.out.printf("The Battery Efficiency is: %.2fkW/h%n", vehicle.calculateFuelEfficiency());
            } else {
                System.out.printf("The Fuel Efficiency: %.2fl/km%n", vehicle.calculateFuelEfficiency());
            }
            System.out.printf("The price is: %.0f€%n", vehicle.getPrice());
            System.out.printf("The speed is: %.2fkm/h%n", vehicle.getSpeed());
        }
    }
}
