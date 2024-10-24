import java.util.HashMap;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();
    private double totalPrice;

    public void addItem(String item, double price) {
        if (groceryList.containsKey(item)) {
            return;
        } else {
            groceryList.put(item, price);
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
        } else {
            return;
        }
    }

    public HashMap<String, Double> displayList() {
        return groceryList;
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateCost() {
        for (Double price : groceryList.values()) {
            totalPrice += price;
        }
        return totalPrice;
    }
}