public class Car {

    private double speed;
    private double gasolineLevel;
    private String typeName;
    private boolean cruiseControl;
    private double targetSpeed;

    public Car(String typeName) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
    }

    public Car(double speed, double gasolineLevel, String typeName) {
        this.speed = speed;
        this.gasolineLevel = gasolineLevel;
        this.typeName = typeName;
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }

    void setTargetSpeed(double speed) {
        this.targetSpeed = speed;
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    public void cruiseControlOff() {
        cruiseControl = false;
        System.out.println("Cruise control is off");
    }

    public double cruiseControlOn() {
        if (getTargetSpeed() < 0 || getTargetSpeed() > 130) {
            System.out.println("Target speed: " + getTargetSpeed());
            System.out.println("Speed must be between 0 and 130. Cruise control is off");
            cruiseControlOff();
            return getSpeed();
        }
        cruiseControl = true;
        System.out.println("Target speed: " + getTargetSpeed());
        System.out.println("Cruise control is on");
        if (getSpeed() < getTargetSpeed()) {
            while (getSpeed() < getTargetSpeed()) {
                this.accelerate();
                System.out.println("Current speed: " + getSpeed());
            }
        } else {
            while (getSpeed() > getTargetSpeed()) {
                this.decelerate(5);
                System.out.println("Current speed: " + getSpeed());
            }
        }
        return this.speed;
    }
}