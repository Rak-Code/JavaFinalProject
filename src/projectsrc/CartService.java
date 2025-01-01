package projectsrc;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private List<CartItem> cartItems;

    public CartService() {
        this.cartItems = new ArrayList<>();
    }

    // Add product to cart
    public String addToCart(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return "Product quantity updated in the cart.";
            }
        }
        cartItems.add(new CartItem(product, quantity));
        return "Product added to the cart.";
    }

    // View cart items
    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n--- Cart Items ---");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "ID", "Name", "Price", "Quantity", "Subtotal");
        System.out.println("------------------------------------------------------------");

        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            System.out.printf("%-5d %-20s %-10.2f %-10d %-10.2f\n",
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    item.getQuantity(),
                    product.getPrice() * item.getQuantity());
        }

        System.out.printf("\nTotal Price: $%.2f\n", calculateTotal());
    }

    // Remove product from cart
    public String removeFromCart(int productId) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == productId) {
                cartItems.remove(item);
                return "Product removed from the cart.";
            }
        }
        return "Product not found in the cart.";
    }

    // Clear the cart
    public void clearCart() {
        cartItems.clear();
    }

    // Calculate total price
    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    // Place order
    public void placeOrder() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty. Add items before placing an order.");
            return;
        }

        System.out.printf("Your order has been placed successfully!\n Total amount: $%.2f\n", calculateTotal());
        clearCart();
    }
    
    
    //
   
}




