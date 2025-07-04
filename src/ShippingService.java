
import java.util.ArrayList;
import java.util.List;
public class ShippingService {
    public void processShippableItems(List<ShippableItem> items) {
        System.out.println("** Shipping Service **");
        if (items.isEmpty()) {
            System.out.println("No shippable items to process");
            return;
        }
        for (ShippableItem item : items) {
            System.out.printf("Processing item: %s, Weight: %.0fg%n", item.getName(), item.getWeight());
        }
    }}