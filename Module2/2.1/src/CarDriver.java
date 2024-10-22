public class CarDriver {

    public static void main(String[] args) {
        Car myCar;

        myCar = new Car(0, 0, "Toyota Corolla");
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.setTargetSpeed(100);
        myCar.cruiseControlOn();
        myCar.setTargetSpeed(50);
        myCar.cruiseControlOn();
        myCar.cruiseControlOff();
        myCar.setTargetSpeed(70);
        myCar.cruiseControlOn();
        myCar.setTargetSpeed(-20);
        myCar.cruiseControlOn();
        myCar.setTargetSpeed(400);
        myCar.cruiseControlOn();
        myCar.setTargetSpeed(50);
        myCar.cruiseControlOn();
        myCar.setTargetSpeed(100);
        myCar.cruiseControlOn();
        myCar.cruiseControlOff();
    }
}