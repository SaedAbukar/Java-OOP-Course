public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("Car", "Petrol", "Red");
        Vehicle motorcycle = new Motorcycle("Motorcycle", "Gasoline", "Black");
        Vehicle bus = new Bus("Bus", "Diesel", 40);

        Vehicle[] vehicles = {car, motorcycle, bus};

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.getInfo();
        }
    }
}
