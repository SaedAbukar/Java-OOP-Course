public class ShapeCalculator {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Triangle triangle = new Triangle(2, 2);
        Rectangle rectangle = new Rectangle(2, 2);
        Shape[] shapes = {circle, rectangle, triangle};

        for (Shape shape : shapes) {
            if (shape == circle) {
                double radius = circle.getRadius();
                String name = "Circle";
                double area = shape.calculateArea();
                System.out.printf("Area of %s with radius %f: %f%n", name, radius, area);
            }
            if (shape == rectangle) {
                double length = rectangle.getLength();
                double height = rectangle.getLength();
                String name = "Rectangle";
                double area = rectangle.calculateArea();
                System.out.printf("Area of %s with width %f and height %f: %f%n", name, length, height, area);
            }
            if (shape == triangle) {
                double base = triangle.getBase();
                double height = triangle.getHeight();
                String name = "Triangle";
                double area = shape.calculateArea();
                System.out.printf("Area of %s with base %f and height %f: %f%n", name, base, height, area);
            }
        }
    }
}
