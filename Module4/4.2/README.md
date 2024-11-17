# Calculator Program

## Description

This project implements a simple `Calculator` class in Java. The
calculator allows for basic operations such as adding positive integers and resetting the value to zero. Negative
integers are not allowed and will result in an exception being thrown.

## Code

```java
public class Calculator {
    private int currentValue;

    public Calculator() {
        currentValue = 0;
    }

    public void reset() {
        currentValue = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed.");
        }
        currentValue += number;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(10);
        calculator.add(5);
        System.out.println("Current value: " + calculator.getCurrentValue());

        try {
            calculator.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        calculator.reset();
        System.out.println("Current value after reset: " + calculator.getCurrentValue());
    }
}
