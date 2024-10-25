import java.util.HashMap;
import java.util.Map;

public class Shopper {
    public static void main(String[] args) {
        GroceryList1 groceryListManager = new GroceryList1();
        ShoppingList bbqList = new ShoppingList();
        ShoppingList campingList = new ShoppingList();
        ShoppingList dinnerList = new ShoppingList();

        bbqList.addItem("Steak", 20, 1);
        bbqList.addItem("Bread", 20, 2);
        bbqList.addItem("Cheese", 20, 3);
        bbqList.addItem("Pizza", 20, 4);
        campingList.addItem("Coffee", 20, 5);
        campingList.addItem("Apple", 20, 6);
        campingList.addItem("Grapes", 20, 7);
        campingList.addItem("Beans", 20, 8);
        dinnerList.addItem("Pasta", 20, 2);
        dinnerList.addItem("Chicken", 20, 1);
        dinnerList.addItem("Tomato", 20, 3);
        dinnerList.addItem("Water", 20, 4);

        groceryListManager.addItem("Backyard BBQ", bbqList);
        groceryListManager.addItem("Weekend Camping", campingList);
        groceryListManager.addItem("Dinner", dinnerList);


        System.out.println("Grocery List:");

        int i = 1;
        for (Map.Entry<String, ShoppingList> entry : groceryListManager.displayList().entrySet()) {
            String category = entry.getKey();
            String itemName;
            HashMap<Double, Integer> map;
            int quantity;
            double price;
            for (Map.Entry<String, HashMap<Double, Integer>> item : entry.getValue().displayList().entrySet()) {
                itemName = item.getKey();
                map = item.getValue();
                for (Map.Entry<Double, Integer> product : map.entrySet()) {
                    price = product.getKey();
                    quantity = product.getValue();
                    System.out.printf("Category: %s, Item %d: %s, Price: %.2f, Quantity: %d%n", category, i, itemName, price, quantity);
                    i++;
                }
            }
        }
        System.out.println(" ");
        System.out.printf("Is \"Backyard BBQ\" shopping list in the grocery list? %s%n", groceryListManager.checkItem("Backyard BBQ") ? "Yes" : "No");
        System.out.println(" ");
        System.out.println("Removing \"Dinner\" shopping list from the list...");
        groceryListManager.removeItem("Dinner");
        System.out.println(" ");
        groceryListManager.updateQuantity("Steak", 8);
        System.out.println("Updated Grocery List:");
        i = 1;
        for (Map.Entry<String, ShoppingList> entry : groceryListManager.displayList().entrySet()) {
            String category = entry.getKey();
            String itemName;
            HashMap<Double, Integer> map;
            int quantity;
            double price;
            for (Map.Entry<String, HashMap<Double, Integer>> item : entry.getValue().displayList().entrySet()) {
                itemName = item.getKey();
                map = item.getValue();
                for (Map.Entry<Double, Integer> product : map.entrySet()) {
                    price = product.getKey();
                    quantity = product.getValue();
                    System.out.printf("Category: %s, Item %d: %s, Price: %.2f€, Quantity: %d%n", category, i, itemName, price, quantity);
                    i++;
                }
            }
        }
        double cost = groceryListManager.calculateCost();
        System.out.printf("Total cost: %.2f€%n", cost);

        System.out.printf("The items in this category: %s%n", groceryListManager.displayCategory("Backyard BBQ").displayList());
    }
}
