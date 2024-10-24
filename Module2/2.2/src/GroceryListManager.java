import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (groceryList.contains(item)) {
            return;
        } else {
            groceryList.add(item);
        }
    }

    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
        } else {
            return;
        }
    }

    public ArrayList<String> displayList() {
        return groceryList;
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        String[] items = {"Apple", "Orange", "Banana"};

        for (String item : items) {
            groceryListManager.addItem(item);
        }

        System.out.println("Grocery List:");

        int i = 1;
        for (String item : groceryListManager.displayList()) {
            System.out.printf("%d. %s%n", i, item);
            i++;
        }
        System.out.println(" ");
        System.out.printf("Is \"Apple\" in the grocery list? %s%n", groceryListManager.checkItem("Apple"));
        System.out.println(" ");
        System.out.println("Removing \"Apple\" from the list...");
        groceryListManager.removeItem("Apple");
        System.out.println(" ");
        System.out.println("Updated Grocery List:");
        i = 1;
        for (String item : groceryListManager.displayList()) {
            System.out.printf("%d. %s%n", i, item);
            i++;
        }
    }
}