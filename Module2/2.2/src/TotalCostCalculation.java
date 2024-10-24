import java.util.Map;

//correct version
public class TotalCostCalculation {
    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        groceryListManager.addItem("Apple", 1);
        groceryListManager.addItem("Orange", 2);
        groceryListManager.addItem("Banana", 3);

        System.out.println("Grocery List:");

        int i = 1;
        for (Map.Entry<String, Double> entry : groceryListManager.displayList().entrySet()) {
            String itemName = entry.getKey();
            double price = entry.getValue();
            System.out.printf("%d. %s, %.2f%n", i, itemName, price);
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
        for (Map.Entry<String, Double> entry : groceryListManager.displayList().entrySet()) {
            String itemName = entry.getKey();
            double price = entry.getValue();
            System.out.printf("%d. %s, %.2f%n", i, itemName, price);
            i++;
        }
        double cost = groceryListManager.calculateCost();
        System.out.printf("Total cost: %.2f%n", cost);
    }
}