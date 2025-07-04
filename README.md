# Fawry Quantum Internship Challenge :shopping_cart:

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

### Example 1: Successful Checkout
```java
Item Cheese = new Item("Cheese", 10, LocalDate.of(2025, 11, 30)); // Quantity 10, expires 2025-11-30
Item Biscuits = new Item("Biscuits", 10, LocalDate.of(2026, 11, 30)); // Quantity 10, expires 2026-11-30
Item TV = new Item("TV", 1, null); // Quantity 1, no expiry
Item MobileScratchCard = new Item("Mobile Scratch Card", 10, null); // Quantity 10, no expiry

Customer john = new Customer("John Doe", 5000.0); // Balance 5000.0
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
**Shipment notice**
Total package weight 6.1 kg
2x Cheese 400g
1x Biscuits 700g
1x TV 5000g
Total package weight 6.1 kg
**Checkout receipt**
2x Cheese 200
1x Biscuits 150
1x TV 3000
5x Mobile Scratch Card 50
**Shipping Service**
Processing item: Cheese, Weight: 200g
Processing item: Biscuits, Weight: 700g
Processing item: TV, Weight: 5000g
--------------------------------
Subtotal 3400
Shipping 61
Amount 3461
New balance 1539
```



### Example 2: Insufficient Balance
```java
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

## 🧠 How to Run
### Prerequisites
- JDK 8+ (verify with `java -version`).
- VS Code with Extension Pack for Java.

### Steps
#### VS Code
1. Open `e-commerce-system` folder.
2. Open `src/Main.java` and click "Run" or right-click "Run Java".
3. Output appears in Terminal.

#### Terminal
1. `cd path/to/FawryInternshipChallenge/src`.
2. Compile: `javac *.java` or list files explicitly.
3. Run: `java Main`.
4. Clean: `del *.class` (Windows) or `rm *.class` (Linux/Mac).
