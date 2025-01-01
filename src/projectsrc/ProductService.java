package projectsrc;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>(); // List to store products
    private int nextProductId; // To generate unique product IDs

    // Constructor
    public ProductService() {
       
        nextProductId = 1; // Start product IDs from 1
        products.add(new Product(nextProductId++, "T-Shirt", "Comfortable cotton t-shirt", 15.99, 100));
        products.add(new Product(nextProductId++, "Jeans", "Classic blue denim jeans", 49.99, 50));
        products.add(new Product(nextProductId++, "Jacket", "Warm winter jacket", 89.99, 30));
    }

    // Add a new product
    public String addProduct(String name, String description, double price, int quantity) {
        Product product = new Product(nextProductId++, name, description, price, quantity);
        products.add(product);
        return "Product added successfully with ID: " + product.getId();
    }

 // View all products
    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- Product List ---");
        System.out.printf("%-5s %-20s %-30s %-10s %-10s\n", "ID", "Name", "Description", "Price", "Stock");
        System.out.println("--------------------------------------------------------------------------");

        for (Product product : products) {
            System.out.printf("%-5d %-20s %-30s %-10.2f %-10d\n",
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getQuantity());
        }
    }


    // Find a product by ID
    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Return null if not found
    }

    // Update a product
    public String updateProduct(int productId, String name, String description, double price, int quantity) {
        Product product = findProductById(productId);
        if (product == null) {
            return "Product with ID " + productId + " not found.";
        }

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        return "Product updated successfully.";
    }

    // Delete a product
    public String deleteProduct(int productId) {
        Product product = findProductById(productId);
        if (product == null) {
            return "Product with ID " + productId + " not found.";
        }

        products.remove(product);
        return "Product deleted successfully.";
    }
    
    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
       return result;
    }
}
