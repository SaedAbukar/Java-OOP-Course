import java.util.Scanner;

public class CoffeeMaker {
    final String normalCoffee = "normal coffee";
    final String espresso = "espresso";
    final int MIN_AMOUNT = 10;
    final int MAX_AMOUNT = 80;
    boolean isOn = false;
    String coffeeType;
    int selection;
    int selectionAmount;
    int increaseOrDecrease;
    int amount = 35;

    Scanner input = new Scanner(System.in);

    public void coffeeMakerOnOff() {
        isOn = !isOn;
    }

    private void coffeeSelector() {
        System.out.printf("Select 1 for %s %n", normalCoffee);
        System.out.printf("Select 2 for %s %n", espresso);
        selection = Integer.parseInt(input.nextLine());

        while (selection < 1 || selection > 2) {
            System.out.println("Please enter a number between 1 and 2");
            selection = Integer.parseInt(input.nextLine());
        }

        switch (selection) {
            case 1:
                coffeeType = normalCoffee;
                break;
            case 2:
                coffeeType = espresso;
                break;
        }
    }

    private void amountSelector() {
        System.out.printf("Current coffee is %s. Current size %d ml.%n", coffeeType, amount);
        System.out.println("Increase by 15 ml (1), decrease by 15 ml (2) or keep the same(3).");
        increaseOrDecrease = Integer.parseInt(input.nextLine());

        while (increaseOrDecrease < 1 || increaseOrDecrease > 3) {
            System.out.println("Please enter a number between 1 and 3");
            increaseOrDecrease = Integer.parseInt(input.nextLine());
        }

        if (increaseOrDecrease == 3) {
            System.out.printf("The size is: %d ml %n", amount);
            return;
        }

        System.out.println("Choose the amount between 1-5");
        selectionAmount = Integer.parseInt(input.nextLine());

        while (selectionAmount < 1 || selectionAmount > 5) {
            System.out.println("Please enter a number between 1 and 5");
            selectionAmount = Integer.parseInt(input.nextLine());
        }

        if (increaseOrDecrease == 1) {
            for (int i = 0; i < selectionAmount; i++) {
                if (amount < MAX_AMOUNT) {
                    System.out.println("Increased to " + amount + " ml");
                    increaseAmount();
                } else {
                    amount = MAX_AMOUNT;
                }
            }
        } else if (increaseOrDecrease == 2) {
            for (int i = 0; i < selectionAmount; i++) {
                if (amount > MIN_AMOUNT) {
                    System.out.println("Decreased to " + amount + " ml");
                    decreaseAmount();
                } else {
                    amount = MIN_AMOUNT;
                }
            }
        }
    }

    private void getAllCoffees() {
        System.out.printf("The coffee options: %s and %s %n", normalCoffee, espresso);
    }

    private String getNormalCoffee() {
        return normalCoffee;
    }

    private String getEspresso() {
        return espresso;
    }

    public void increaseAmount() {
        if (amount > MAX_AMOUNT) {
            amount = MAX_AMOUNT;
        } else {
            amount += 15;
        }
    }

    public void decreaseAmount() {
        if (amount < MIN_AMOUNT) {
            amount = MIN_AMOUNT;
        } else {
            amount -= 15;
        }
    }

    private int getAmount() {
        return amount;
    }

    private String getCoffeeType() {
        return coffeeType;
    }

    public void coffeeMaker() {
        if (!isOn) {
            System.out.println("The coffee maker is off. Turn it on");
            return;
        }
        System.out.println("The coffee machine is on.");
        System.out.printf("The current coffee is %s.%n", coffeeType);
        System.out.printf("The min amount is %d ml and the max amount is %d ml.%n", MIN_AMOUNT, MAX_AMOUNT);
        getAllCoffees();
        coffeeSelector();
        amountSelector();
        System.out.printf("Here is your coffee type: %s. The size of the drink is: %d ml. Enjoy!%n", getCoffeeType(), getAmount());
    }
}
