import java.util.HashMap;

public class ShoppingList {
    private HashMap<String, HashMap<Double, Integer>> shoppingList = new HashMap<>();

    public void addItem(String name, double price, int quantity) {
        if (shoppingList.containsKey(name)) {
            shoppingList.get(name).put(price, quantity);
        } else {
            HashMap<Double, Integer> item = new HashMap<>();
            item.put(price, quantity);
            shoppingList.put(name, item);
        }
    }

    public void removeItem(String item) {
        shoppingList.remove(item);
    }

    public HashMap<String, HashMap<Double, Integer>> displayList() {
        return shoppingList;
    }

    public boolean checkItem(String item) {
        boolean found = false;
        for (String name : shoppingList.keySet()) {
            if (name.equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public double calculateCost() {
        int totalPrice = 0;
        double total = 0;
        for (String name : shoppingList.keySet()) {
            HashMap<Double, Integer> map = shoppingList.get(name);
            for (Double price : map.keySet()) {
                total += price;
            }
            for (Integer quantity : map.values()) {
                total *= quantity;
            }
            totalPrice += total;
        }
        return totalPrice;
    }

    public HashMap<Double, Integer> displayCategory(String name) {
        return shoppingList.get(name);
    }

    public int updateQuantity(String item, int newQuantity) {
        int updatedQuantity = 0;
        String itemMatch = "";
        String categoryMatch = "";
        boolean found = false;
        for (String name : shoppingList.keySet()) {
            if (name.equals(item)) {
                found = true;
                itemMatch = name;
                break;
            }
        }
        if (found) {
            HashMap<Double, Integer> map = shoppingList.get(itemMatch);
            double price = map.keySet().iterator().next();
            int currentQuantity = map.values().iterator().next();
            updatedQuantity = currentQuantity + newQuantity;
            map.put(price, updatedQuantity);
        }
        return updatedQuantity;
    }

}
