public class SportsCar extends Car {

    public SportsCar(double speed, double gasolineLevel, String typeName) {
        super(speed, gasolineLevel, typeName);
    }

    @Override
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 20;
            gasolineLevel -= 5;
        } else {
            speed = 0;
        }
    }

    @Override
    void decelerate(int amount) {
        double decelerate = 10;
        if (gasolineLevel > 0) {
            if (amount > 0) {
                speed = Math.max(0, speed - amount - decelerate);
            }
        } else
            speed = 0;
    }
}