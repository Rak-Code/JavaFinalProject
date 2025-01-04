package projectsrc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>(); // List to store products
    private int nextProductId; // To generate unique product IDs
    
    private Connection connection;

    // Constructor
    public ProductService() {
    	
    	
       
        nextProductId = 1; // Start product IDs from 1
        products.add(new Product(nextProductId++, "T-Shirt", "Comfortable cotton t-shirt", 500, 100));
        products.add(new Product(nextProductId++, "Jeans", "Classic blue denim jeans", 1200, 50));
        products.add(new Product(nextProductId++, "Jacket", "Warm winter jacket", 2000, 30));
        
        try {
			
        	connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
			e.getMessage();
			throw new RuntimeException("Failed to connect to the database." + e.getMessage());
		}
    }

    // Add a new product
    public String addProduct(String name, String description, double price, int quantity) {
        String insertQuery = "INSERT INTO products (name, description, price, stock_quantity) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);

            stmt.executeUpdate();

            // Retrieve the generated product ID
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                return "Product added successfully with ID: " + generatedId;
            }
        } catch (SQLException e) {
            return "Error occurred while adding product: " + e.getMessage();
        }
        return "Failed to add product.";
    }


//        Product product = new Product(nextProductId++, name, description, price, quantity);
//        products.add(product);
//        return "Product added successfully with ID: " + product.getId();
//    }

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
