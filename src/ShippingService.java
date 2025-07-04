
import java.util.ArrayList;
import java.util.List;
public class ShippingService {
    public void processShippableItems(List<ShippableItem> items, List<Integer> quantities) {
        System.out.println("** Shipping notice **");
        if (items.isEmpty()) {
            System.out.println("No shippable items to process");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            ShippableItem item = items.get(i);
            int quantity = quantities.get(i);
            System.out.printf("%dx %s, Weight: %.0fg%n", quantity, item.getName(), item.getWeight()*quantity);
        }
    }}