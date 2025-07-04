import java.time.LocalDate;
import java.util.Map;
public class Main {
    
    public static void main(String[] args) {
        try {
        Checkout checkout = new Checkout();

        Item Cheese=new Item("Cheese", 2, LocalDate.of(2025, 11, 30));//cheese with quantity 10 and expiry date
        Item Biscuits=new Item("Biscuits", 10, LocalDate.of(2026, 11, 30));//biscuits with quantity 10 and expiry date
        Item TV=new Item("TV", 1, null);//TV with quantity 1 and no expiry date
        Item MobileScratchCard=new Item("Mobile Scratch Card", 10, null);//Mobile Scratch Card with quantity 10 and no expiry date

        Customer john = new Customer("John Doe", 5000.0);// John with balance 5000.0
        Cart cart = new Cart();
        cart.add(Cheese, 2);
        cart.add(Biscuits, 1);
        cart.add(MobileScratchCard, 5);
        cart.add(TV, 1);

        checkout.checkout(john, cart);



         Cart cart2 = new Cart();
        cart2.add(Cheese, 2);
       
        checkout.checkout(john, cart2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}