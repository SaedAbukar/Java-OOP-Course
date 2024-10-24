import java.util.HashMap;
import java.util.Map;

public class QuantityTracking {
    public static void main(String[] args) {
        GroceryList1 groceryListManager = new GroceryList1();

        groceryListManager.addItem("Apple", 1, "Fruits", 2);
        groceryListManager.addItem("Milk", 2, "Dairy", 2);
        groceryListManager.addItem("Bread", 3, "Bakery", 1);

        System.out.println("Grocery List:");

        int i = 1;
        for (Map.Entry<String, HashMap<String, HashMap<Double, Integer>>> entry : groceryListManager.displayList().entrySet()) {
            String category = entry.getKey();
            String itemName = "";
            HashMap<Double, Integer> map;
            int quantity = 0;
            double price = 0;
            for (Map.Entry<String, HashMap<Double, Integer>> item : entry.getValue().entrySet()) {
                itemName = item.getKey();
                map = item.getValue();
                for (Map.Entry<Double, Integer> product : map.entrySet()) {
                    price = product.getKey();
                    quantity = product.getValue();
                }
            }
            System.out.printf("%d. Category: %s, Item: %s, Price: %.2f, Quantity: %d%n", i, category, itemName, price, quantity);
            i++;
        }
        System.out.println(" ");
        System.out.printf("Is \"Apple\" in the grocery list? %s%n", groceryListManager.checkItem("apple"));
        System.out.println(" ");
        System.out.println("Removing \"Apple\" from the list...");
        groceryListManager.removeItem("Apple");
        System.out.println(" ");
        groceryListManager.updateQuantity("Milk", 8);
        System.out.println("Updated Grocery List:");
        i = 1;
        for (Map.Entry<String, HashMap<String, HashMap<Double, Integer>>> entry : groceryListManager.displayList().entrySet()) {
            String category = entry.getKey();
            String itemName = "";
            HashMap<Double, Integer> map;
            int quantity = 0;
            double price = 0;
            for (Map.Entry<String, HashMap<Double, Integer>> item : entry.getValue().entrySet()) {
                itemName = item.getKey();
                map = item.getValue();
                for (Map.Entry<Double, Integer> product : map.entrySet()) {
                    price = product.getKey();
                    quantity = product.getValue();
                }
            }
            System.out.printf("%d. Category: %s, Item: %s, Price: %.2f, Quantity: %d%n", i, category, itemName, price, quantity);
            i++;
        }
        double cost = groceryListManager.calculateCost();
        System.out.printf("Total cost: %.2f%n", cost);

        System.out.printf("The items in this category: %s%n", groceryListManager.displayCategory("Dairy"));
    }
}