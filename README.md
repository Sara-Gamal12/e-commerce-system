# Fawry Quantum Internship Challenge :
<p align="center">
  <img src="https://cdn.dribbble.com/users/656025/screenshots/2782309/tienda.gif" alt="E-commerce Animation" width="300" />
</p>

## 🚀 Overview :
This project implements a shopping cart and checkout system for the Fawry Quantum Internship Challenge, featuring item management, expiration checks, shipping, and customer balance handling. 

---

## 💡Assumptions : 
- Items are predefined in `Item.java` with fixed properties (e.g., Cheese: 200g, $100, expires, shippable; Mobile Scratch Card: 0g, $10, non-expiring, non-shippable).
- Quantity and expiration dates are adjustable per item instance.
- Shipping costs $10/kg for shippable items only; non-shippable items are excluded from calculations.
- Stock is reduced after successful checkout, with cart additions validated against stock levels.
- Checkout fails if items are expired, stock is insufficient, or the balance is too low.

---

## 💻Code Examples :

### Example 1: Successful Checkout, Insufficient Balance, and Insufficient Stock
This example showcases a successful checkout, followed by scenarios with insufficient balance (using the same customer after their balance is reduced) and insufficient stock (resulting from the successful transaction).
```java
        //add those items to the stock
        Item Cheese = new Item("Cheese", 3, LocalDate.of(2025, 11, 30)); // Quantity 3, expires 2025-11-30
        Item Biscuits = new Item("Biscuits", 10, LocalDate.of(2026, 11, 30)); // Quantity 10, expires 2026-11-30
        Item TV = new Item("TV", 10, null); // Quantity 1, no expiry
        Item MobileScratchCard = new Item("Mobile Scratch Card", 10, null); // Quantity 10, no expiry

        Cart cart = new Cart();
        cart.add(Cheese, 2); // Add 2 more Cheese
        cart.add(Biscuits, 1); // Add 1 more Biscuit
        cart.add(MobileScratchCard, 5); // Add 5 more Mobile Scratch Cards
        cart.add(TV, 1); // Add 1 more TV

        // Case 1: Successful Checkout
        Customer john = new Customer("John Doe", 5000.0); // Balance 5000.0
        Checkout checkoutSuccess = new Checkout();
        System.out.println("1st Case: Successful Checkout");
        checkoutSuccess.checkout(john, cart); 

        // Case 2: Insufficient Balance
        Checkout checkoutInsufficientBalance = new Checkout();
        System.out.println("2nd Case: Insufficient Balance");

        checkoutInsufficientBalance.checkout(john, cart); 

        // Case 3: Insufficient Stock
        Cart lowStockCart = new Cart();
        lowStockCart.add(Cheese, 2); // Request 2, but only 1 in stock
        Customer johnInsufficientStock = new Customer("John Doe", 5000.0); // Balance 5000.0
        Checkout checkoutInsufficientStock = new Checkout();
        System.out.println("3rd Case: Insufficient Stock");
        checkoutInsufficientStock.checkout(johnInsufficientStock, lowStockCart);

```
#### Console Output
```
1st Case: Successful Checkout
** Shipping notice **
1x TV, Weight: 5000g
1x Biscuits, Weight: 700g
2x Cheese, Weight: 400g
Total package weight 6.1 kg
** Checkout receipt **
1x TV 3000
5x Mobile Scratch Card 50
1x Biscuits 150
2x Cheese 200
--------------------------------
Subtotal 3400
Shipping 61
Amount 3461
New balance 1539

2nd Case: Insufficient Balance
Insufficient balance for checkout. Total: 3461, Balance: 1539

3rd Case: Insufficient Stock
Not enough stock for item Cheese
```



### Example 2: Insufficient Balance
```java
 //add those items to the stock
Item Cheese = new Item("Cheese", 10, LocalDate.of(2025, 11, 30)); // Quantity 10, expires 2025-11-30
Item Biscuits = new Item("Biscuits", 10, LocalDate.of(2026, 11, 30)); // Quantity 10, expires 2026-11-30
Item TV = new Item("TV", 1, null); // Quantity 1, no expiry
Item MobileScratchCard = new Item("Mobile Scratch Card", 10, null); // Quantity 10, no expiry

Customer john = new Customer("John Doe", 3000.0); // Balance 3000.0
Cart cart = new Cart();
cart.add(Cheese, 2); // Add 2 more Cheese
cart.add(Biscuits, 1); // Add 1 more Biscuit
cart.add(MobileScratchCard, 5); // Add 5 more Mobile Scratch Cards
cart.add(TV, 1); // Add 1 more TV

Checkout checkout = new Checkout();
checkout.checkout(john, cart);
```
#### Console Output
```
Insufficient balance for checkout. Total: 3461, Balance: 3000
```


### Example 3: Expired Item
```java
 //add those items to the stock
Item Cheese = new Item("Cheese", 10, LocalDate.of(2023, 11, 30)); // Quantity 10, expired as of 2023-07-04
Item Biscuits = new Item("Biscuits", 10, LocalDate.of(2026, 11, 30)); // Quantity 10, expires 2026-11-30
Item TV = new Item("TV", 1, null); // Quantity 1, no expiry
Item MobileScratchCard = new Item("Mobile Scratch Card", 10, null); // Quantity 10, no expiry

Customer john = new Customer("John Doe", 5000.0); // Balance 3000.0
Cart cart = new Cart();
cart.add(Cheese, 2); // Add 2 more Cheese
cart.add(Biscuits, 1); // Add 1 more Biscuit
cart.add(MobileScratchCard, 5); // Add 5 more Mobile Scratch Cards
cart.add(TV, 1); // Add 1 more TV

Checkout checkout = new Checkout();
checkout.checkout(john, cart);
```
#### Console Output
```
Item Cheese has expired and cannot be checked out
```



### Example 4: Insufficient Stock
```java
 //add those items to the stock
Item Cheese = new Item("Cheese", 1, LocalDate.of(2026, 11, 30)); // Quantity 1, expired as of 2026-07-04
Item Biscuits = new Item("Biscuits", 10, LocalDate.of(2026, 11, 30)); // Quantity 10, expires 2026-11-30
Item TV = new Item("TV", 1, null); // Quantity 1, no expiry
Item MobileScratchCard = new Item("Mobile Scratch Card", 10, null); // Quantity 10, no expiry

Customer john = new Customer("John Doe", 5000.0); // Balance 3000.0
Cart cart = new Cart();
cart.add(Cheese, 2); // Add 2 more Cheese
cart.add(Biscuits, 1); // Add 1 more Biscuit
cart.add(MobileScratchCard, 5); // Add 5 more Mobile Scratch Cards
cart.add(TV, 1); // Add 1 more TV

Checkout checkout = new Checkout();
checkout.checkout(john, cart);
```
#### Console Output
```
Not enough stock for item Cheese
```

### Example 5:empty cart
```java
 //add those items to the stock
Item Cheese = new Item("Cheese", 1, LocalDate.of(2026, 11, 30)); // Quantity 1, expired as of 2026-07-04
Item Biscuits = new Item("Biscuits", 10, LocalDate.of(2026, 11, 30)); // Quantity 10, expires 2026-11-30
Item TV = new Item("TV", 1, null); // Quantity 1, no expiry
Item MobileScratchCard = new Item("Mobile Scratch Card", 10, null); // Quantity 10, no expiry

Customer john = new Customer("John Doe", 5000.0); // Balance 3000.0
Cart cart = new Cart();
Checkout checkout = new Checkout();
checkout.checkout(john, cart);
```
#### Console Output
```
** Shipping notice **
No shippable items to process
Total package weight 0.0 kg
** Checkout receipt **
No items to checkout
```

## 🧠 How to Run
### Prerequisites
- JDK 8+ (verify with `java -version`).
- VS Code with Extension Pack for Java.

### Steps

#### In Terminal
1. `cd path/to/FawryInternshipChallenge/src`.
2. Compile: `javac *.java` or list files explicitly.
3. Run: `java Main`.
4. Clean: `del *.class` (Windows) or `rm *.class` (Linux/Mac).
