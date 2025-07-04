import java.time.LocalDate;
import java.util.Map;
public class Main {
    
    public static void main(String[] args) {
        try {
           Item Cheese=new Item("Cheese", 10, LocalDate.of(2025, 11, 30));
           Item Biscuits=new Item("Biscuits", 10, LocalDate.of(2026, 11, 30));
           Item TV=new Item("TV", 1, null);
            Item MobileScratchCard=new Item("Mobile Scratch Card", 10, null);



        Customer john = new Customer("John Doe", 5000.0);
           Cart cart = new Cart();
           cart.add(Cheese, 2);
           cart.add(Biscuits, 1);
        cart.add(MobileScratchCard, 5);
           cart.add(TV, 1);
        Checkout checkout = new Checkout();
        checkout.checkout(john, cart);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}