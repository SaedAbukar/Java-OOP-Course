import java.util.HashMap;
import java.util.Objects;

public class GroceryList1 {
    private HashMap<String, HashMap<String, HashMap<Double, Integer>>> groceryList = new HashMap<>();
    private double totalPrice;
    private String fruits = "Fruits";
    private String dairy = "Dairy";
    private String bakery = "Bakery";

    public void addItem(String name, double price, String category, int quantity) {
        if (!Objects.equals(category, fruits) && !Objects.equals(category, dairy) && !Objects.equals(category, bakery)) {
            return;
        }
        if (groceryList.containsKey(category)) {
            if (groceryList.get(category).containsKey(name)) {
                groceryList.get(category).get(name).put(price, quantity);
            } else {
                HashMap<String, HashMap<Double, Integer>> map = new HashMap<>();
                HashMap<Double, Integer> item = new HashMap<>();
                item.put(price, quantity);
                map.put(name, item);
            }
            ;
        } else {
            HashMap<String, HashMap<Double, Integer>> map = new HashMap<>();
            HashMap<Double, Integer> item = new HashMap<>();
            item.put(price, quantity);
            map.put(name, item);
            groceryList.put(category, map);
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

    public HashMap<String, HashMap<String, HashMap<Double, Integer>>> displayList() {
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
        double total = 0;
        for (String category : groceryList.keySet()) {
            for (String name : groceryList.get(category).keySet()) {
                HashMap<Double, Integer> map = groceryList.get(category).get(name);
                for (Double price : map.keySet()) {
                    total += price;
                }
                for (Integer quantity : map.values()) {
                    total *= quantity;
                }
                totalPrice += total;

            }
        }
        return totalPrice;
    }

    public HashMap<String, HashMap<Double, Integer>> displayCategory(String category) {
        return groceryList.get(category);
    }

    public int updateQuantity(String item, int newQuantity) {
        int updatedQuantity = 0;
        String itemMatch = "";
        String categoryMatch = "";
        boolean found = false;
        for (String category : groceryList.keySet()) {
            for (String name : groceryList.get(category).keySet()) {
                if (name.equals(item)) {
                    found = true;
                    itemMatch = name;
                    categoryMatch = category;
                    break;
                }
            }
        }
        if (found) {
            HashMap<Double, Integer> map = groceryList.get(categoryMatch).get(itemMatch);
            double price = map.keySet().iterator().next();
            int currentQuantity = map.values().iterator().next();
            updatedQuantity = currentQuantity + newQuantity;
            map.put(price, updatedQuantity);
        }
        return updatedQuantity;
    }
}