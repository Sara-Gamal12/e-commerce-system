import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> items;  // Maps Item to its quantity in the cart

    public Cart() {
        items = new HashMap<>();
    }

    public void add(Item item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        items.merge(item, quantity, Integer::sum);
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            totalWeight += entry.getKey().getWeight() * entry.getValue();
        }
        return totalWeight;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            subtotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subtotal;
    }
}