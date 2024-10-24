import java.util.HashMap;

public class ShoppingList {
    private HashMap<String, HashMap<Double, Integer>> shoppingList = new HashMap<>();

    public void addItem(String name, double price, int quantity) {
        if (shoppingList.containsKey(name)) {
            shoppingList.get(name).put(price, quantity);
        } else {
            HashMap<String, HashMap<Double, Integer>> map = new HashMap<>();
            HashMap<Double, Integer> item = new HashMap<>();
            item.put(price, quantity);
            map.put(name, item);
        }
    }

    public void removeItem(String item) {
        String itemMatch = "";
        boolean found = false;
        for (String name : shoppingList.keySet()) {
            if (name.equals(item)) {
                itemMatch = name;
                found = true;
            }
        }
        if (found) {
            shoppingList.remove(itemMatch);
        }
    }

    public HashMap<String, HashMap<Double, Integer>> displayList() {
        return shoppingList;
    }
}
