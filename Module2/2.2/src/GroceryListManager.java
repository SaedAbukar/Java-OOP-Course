import java.util.HashMap;
import java.util.Objects;

public class GroceryListManager {
    private HashMap<String, HashMap<String, Double>> groceryList = new HashMap<>();
    private double totalPrice;
    private String fruits = "Fruits";
    private String dairy = "Dairy";
    private String bakery = "Bakery";

    public void addItem(String name, double price, String category) {
        if (!Objects.equals(category, fruits) && !Objects.equals(category, dairy) && !Objects.equals(category, bakery)) {
            return;
        }
        if (groceryList.containsKey(category)) {
            groceryList.get(category).put(name, price);
        } else {
            HashMap<String, Double> item = new HashMap<>();
            item.put(name, price);
            groceryList.put(category, item);
        }
    }

    public void removeItem(String item) {
        String itemMatch = "";
        String categoryMatch = "";
        boolean found = false;
        for (String category : groceryList.keySet()) {
            for (String name : groceryList.get(category).keySet()) {
                if (name.equals(item)) {
                    itemMatch = name;
                    categoryMatch = category;
                    found = true;
                }
            }
        }
        if (found) {
            groceryList.get(categoryMatch).remove(itemMatch);
        }

    }

    public HashMap<String, HashMap<String, Double>> displayList() {
        return groceryList;
    }

    public boolean checkItem(String item) {
        boolean found = false;
        for (String category : groceryList.keySet()) {
            for (String name : groceryList.get(category).keySet()) {
                if (name.equals(item)) {
                    found = true;
                }
            }
        }
        return found;
    }

    public double calculateCost() {
        totalPrice = 0;
        for (String category : groceryList.keySet()) {
            for (String name : groceryList.get(category).keySet()) {
                totalPrice += groceryList.get(category).get(name);
            }
        }
        return totalPrice;
    }

    public HashMap<String, Double> displayCategory(String category) {
        return groceryList.get(category);
    }
}