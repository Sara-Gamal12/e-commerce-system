import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Item implements ShippableItem {
      int quantity;
        LocalDate expiresIn;

    private static class ItemProperties {
        double weight; // in grams
        boolean expires;
        boolean shippable;
        double price;
      
        ItemProperties(double weight, boolean expires, boolean shippable, double price) {
            this.weight = weight;
            this.expires = expires;
            this.shippable = shippable;
            this.price = price;
        }
    }

    private static final Map<String, ItemProperties> ITEM_PROPERTIES;

    static {
        Map<String, ItemProperties> tempMap = new HashMap<>();
        tempMap.put("Cheese", new ItemProperties(200.0, true, true, 100.0)); // 200g, expires, shippable, $100
        tempMap.put("Biscuits", new ItemProperties(700.0, true, true, 150.0)); // 700g, expires, shippable, $150
        tempMap.put("TV", new ItemProperties(5000.0, false, true, 3000.0)); // 5000g, non-expiring, shippable, $300
        tempMap.put("Mobile Scratch Card", new ItemProperties(0.0, false, false, 10.0)); // 0g, non-expiring, non-shippable, $0
        ITEM_PROPERTIES = Collections.unmodifiableMap(tempMap);
    }

    private String name;
    private double price;
    private double weight;
    private boolean expires;
    private boolean shippable;

    public Item(String name,int quantity,LocalDate expiresIn) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty");
        }
        if (!ITEM_PROPERTIES.containsKey(name)) {
            throw new IllegalArgumentException("Unknown item: " + name);
        }
       
        ItemProperties props = ITEM_PROPERTIES.get(name);
        if (props.shippable && props.weight <= 0) {
            throw new IllegalArgumentException("Shippable item " + name + " must have positive weight");
        }
        this.name = name;
        this.price = props.price;
        this.weight = props.weight;
        this.expires = props.expires;
        this.shippable = props.shippable;
        if (expiresIn != null && !props.expires) {
            throw new IllegalArgumentException("Item " + name + " does not expire, cannot set expiration date");
        }
        this.expiresIn = expiresIn;
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public boolean Expired() {
         LocalDate currentDate = LocalDate.now();

        return this.expires && this.expiresIn.isBefore(currentDate);
    }

    public boolean isShippable() {
        return shippable;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public static Map<String, ItemProperties> getItemProperties() {
        return ITEM_PROPERTIES;
    }
}