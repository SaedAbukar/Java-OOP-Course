public class Bus extends Car {
    private double passengers;

    public Bus(Double speed, double gasolineLevel, String typeName, double passengers) {
        super(speed, gasolineLevel, typeName);
        this.passengers = passengers;
    }

    public void passengerEnter() {
        passengers++;
    }

    public void passengerExit() {
        passengers--;
    }

    public void passengerEnter(double passengers) {
        passengers += passengers;
    }

    public void passengerExit(double passengers) {
        passengers -= passengers;
    }

}
