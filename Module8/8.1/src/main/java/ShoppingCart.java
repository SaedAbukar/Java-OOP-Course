import java.util.HashMap;

public class ShoppingCart {
    private final HashMap<String, Double> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addItem(String item, double price) {
        cart.put(item, price);
    }

    public void removeItem(String item) {
        cart.remove(item);
    }

    public int getItemCount() {
        return cart.size();
    }

    public double calculateTotal() {
        double total = 0.0;
        for (String item : cart.keySet()) {
            total += cart.get(item);
        }
        return total;
    }
}
