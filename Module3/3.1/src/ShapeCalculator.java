public class ShapeCalculator {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "Blue");
        Triangle triangle = new Triangle(2, 2, "Red");
        Rectangle rectangle = new Rectangle(2, 2, "Green");
        Shape[] shapes = {circle, rectangle, triangle};

        for (Shape shape : shapes) {
            if (shape == circle) {
                double radius = circle.getRadius();
                String name = "Circle";
                double area = shape.calculateArea();
                String color = shape.getColor();
                System.out.printf("Area of %s %s with radius %f: %f%n", color, name, radius, area);
            }
            if (shape == rectangle) {
                double length = rectangle.getLength();
                double height = rectangle.getLength();
                String name = "Rectangle";
                double area = rectangle.calculateArea();
                String color = shape.getColor();
                System.out.printf("Area of %s %s with width %f and height %f: %f%n", color, name, length, height, area);
            }
            if (shape == triangle) {
                double base = triangle.getBase();
                double height = triangle.getHeight();
                String name = "Triangle";
                double area = shape.calculateArea();
                String color = shape.getColor();
                System.out.printf("Area of %s %s with base %f and height %f: %f%n", color, name, base, height, area);
            }
        }
    }
}
