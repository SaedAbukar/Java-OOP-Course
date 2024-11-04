public class Triangle extends Shape {
    private double base;
    private double height;


    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

}
