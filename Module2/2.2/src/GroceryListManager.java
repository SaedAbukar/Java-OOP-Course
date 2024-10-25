import java.util.HashMap;

public class GroceryListManager {
    private HashMap<String, ShoppingList> groceryList = new HashMap<>();
    private double totalPrice;
    private String fruits = "Fruits";
    private String dairy = "Dairy";
    private String bakery = "Bakery";

    public void addItem(String category, ShoppingList shoppingList) {
        if (!groceryList.containsKey(category)) {
            groceryList.put(category, shoppingList);
        }
    }

    public void removeItem(String category) {
        groceryList.remove(category);
    }

    public HashMap<String, ShoppingList> displayList() {
        return groceryList;
    }

    public boolean checkItem(String category) {
        return groceryList.containsKey(category);
    }

    public double calculateCost() {
        totalPrice = 0;
        for (String category : groceryList.keySet()) {
            HashMap<String, HashMap<Double, Integer>> item = groceryList.get(category).displayList();
            for (String itemCategory : item.keySet()) {
                double currentPrice = 0;
                int currentQuantity = 0;
                HashMap<Double, Integer> itemPrice = item.get(itemCategory);
                for (Double price : itemPrice.keySet()) {
                    currentPrice = price;
                }
                for (Integer quantity : itemPrice.values()) {
                    currentQuantity = quantity;
                }
                totalPrice += currentPrice * currentQuantity;
            }
        }
        return totalPrice;
    }

    public ShoppingList displayCategory(String category) {
        return groceryList.get(category);
    }

    public int updateQuantity(String item, int newQuantity) {
        int updatedQuantity = 0;
        String itemMatch = "";
        String categoryMatch = "";
        boolean found = false;
        for (String category : groceryList.keySet()) {
            for (String name : groceryList.get(category).displayList().keySet()) {
                if (name.equals(item)) {
                    found = true;
                    itemMatch = name;
                    categoryMatch = category;
                    break;
                }
            }
        }
        if (found) {
            HashMap<Double, Integer> map = groceryList.get(categoryMatch).displayList().get(itemMatch);
            double price = map.keySet().iterator().next();
            int currentQuantity = map.values().iterator().next();
            updatedQuantity = currentQuantity + newQuantity;
            map.put(price, updatedQuantity);
        }
        return updatedQuantity;
    }

}