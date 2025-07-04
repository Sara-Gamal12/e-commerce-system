
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Checkout {
    private static final double SHIPPING_RATE_PER_KG = 10; 

    public void checkout(Customer customer, Cart cart) {
        List<ShippableItem> shippableItems = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
                double subtotal = cart.getSubtotal();
                double shippingCost = (cart.getTotalWeight() / 1000) * SHIPPING_RATE_PER_KG;

        
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }

    for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            if(item.isShippable()) {
                shippableItems.add(item);
                quantities.add(quantity);
            }
            if (item.Expired()) {
                 System.out.println("Item " + item.getName() + " has expired and cannot be checked out");
                 return;
            }
            if(item.quantity<quantity) {
                 System.out.println("Not enough stock for item " + item.getName());
                 return;
            }
             if(subtotal + shippingCost>customer.getBalance()) {
            System.out.printf("Insufficient balance for checkout. Total: %.0f, Balance: %.0f%n", subtotal + shippingCost, customer.getBalance());
            return;
        }
        if(cart.getItems().isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

}
        // Shipment notice
        
        double totalWeightGrams = cart.getTotalWeight();
         ShippingService  shippingService = new ShippingService();
         shippingService.processShippableItems(shippableItems, quantities);
           
            System.out.printf("Total package weight %.1f kg%n", totalWeightGrams / 1000);
    

        // Checkout receipt
        System.out.println("** Checkout receipt **");
        if (totalWeightGrams == 0) {
            System.out.println("No items to checkout");
            return;
        }
        for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
            
            Item item = entry.getKey();
            int quantity = entry.getValue();
            double itemTotalPrice = item.getPrice() * quantity;
            System.out.printf("%dx %s %.0f%n", quantity, item.getName(), itemTotalPrice);
            item.setQuantity(item.getQuantity() - quantity);

        }
        
System.out.println("--------------------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingCost);
        System.out.printf("Amount %.0f%n", subtotal + shippingCost);
       
            customer.setBalance(customer.getBalance() - (subtotal + shippingCost));
        System.out.printf("New balance %.0f%n", customer.getBalance());

    }

}