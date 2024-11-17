public class Calculator {
    private int currentValue;

    // Constructor
    public Calculator() {
        currentValue = 0;
    }

    // Method to reset the calculator to zero
    public void reset() {
        currentValue = 0;
    }

    // Method to add a positive integer to the calculator
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed.");
        }
        currentValue += number;
    }

    // Method to return the current value
    public int getCurrentValue() {
        return currentValue;
    }

    // Temporary main method to demonstrate usage
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(10);
        calculator.add(5);
        System.out.println("Current value: " + calculator.getCurrentValue()); // Should print 15

        try {
            calculator.add(-3); // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        calculator.reset();
        System.out.println("Current value after reset: " + calculator.getCurrentValue()); // Should print 0
    }
}
