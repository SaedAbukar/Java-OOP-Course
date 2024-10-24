import java.util.HashMap;
import java.util.Map;

public class TotalCostCalculation {
    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        groceryListManager.addItem("Apple", 1, "Fruits");
        groceryListManager.addItem("Milk", 2, "Dairy");
        groceryListManager.addItem("Bread", 3, "Bakery");

        System.out.println("Grocery List:");

        int i = 1;
        for (Map.Entry<String, HashMap<String, Double>> entry : groceryListManager.displayList().entrySet()) {
            String category = entry.getKey();
            String itemName = "";
            double price = 0;
            for (Map.Entry<String, Double> item : entry.getValue().entrySet()) {
                itemName = item.getKey();
                price = item.getValue();
            }
            System.out.printf("%d. %s, %s, %.2f%n", i, category, itemName, price);
            i++;
        }
        System.out.println(" ");
        System.out.printf("Is \"Apple\" in the grocery list? %s%n", groceryListManager.checkItem("apple"));
        System.out.println(" ");
        System.out.println("Removing \"Apple\" from the list...");
        groceryListManager.removeItem("Apple");
        System.out.println(" ");
        System.out.println("Updated Grocery List:");
        i = 1;
        for (Map.Entry<String, HashMap<String, Double>> entry : groceryListManager.displayList().entrySet()) {
            String category = entry.getKey();
            String itemName = "";
            double price = 0;
            for (Map.Entry<String, Double> item : entry.getValue().entrySet()) {
                itemName = item.getKey();
                price = item.getValue();
            }
            System.out.printf("%d. %s, %s, %.2f%n", i, category, itemName, price);
            i++;
        }
        double cost = groceryListManager.calculateCost();
        System.out.printf("Total cost: %.2f%n", cost);

        System.out.printf("The items in this category: %s%n", groceryListManager.displayCategory("Fruits"));
    }
}