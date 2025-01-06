package projectsrc;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        UserService userService = new UserService(); 
        ProductService productService = new ProductService(); 
        CartService cartService = new CartService();
        Scanner scanner = new Scanner(System.in);
        
        
//        DatabaseConnection.checkConnection();

       
        while (true) {
            System.out.println("\n--- E-Commerce (CLothingBrand) Backend System ---")
            ;
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: // Register
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    String registrationStatus = userService.registerUser(username, password, email);
                    System.out.println(registrationStatus);
                    break;

                case 2: // Login
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    User user = userService.loginUser(loginUsername, loginPassword);
                    if (user != null) {
                        System.out.println("Login successful! Welcome, " + user.getUsername());

                        if (user.getUsername().equals("admin")) {
                            // Admin menu
                            while (true) {
                                System.out.println("\n--- Admin Menu ---");
                                System.out.println("1. View All Users");
                                System.out.println("2. Manage Products");
                                System.out.println("3. Logout");
                                System.out.print("Choose an option: ");
                                int adminChoice = scanner.nextInt();
                                scanner.nextLine(); 

                                if (adminChoice == 1) {
                                    System.out.println("\n-----Registered Users------");
                                    

                                    System.out.printf("%-15s %-20s %-30s\n", "Username", "Password", "Email");
                                    System.out.println("---------------------------------------------------------------");

                                    for (User registeredUser : userService.getAllUsers()) {
                                        System.out.printf("%-15s %-20s %-30s\n",
                                        		registeredUser.getUsername(),
                                        		registeredUser.getPassword(),
                                        		registeredUser.getEmail());
                                    }
                                } else if (adminChoice == 2) {
                                    
                                    while (true) {
                                        System.out.println("\n--- Product Management ---");
                                        System.out.println("1. Add Product");
                                        System.out.println("2. View Products");
                                        System.out.println("3. Update Product");
                                        System.out.println("4. Delete Product");
                                        System.out.println("5. Back to Admin Menu");
                                        System.out.print("Choose an option: ");
                                        int productChoice = scanner.nextInt();
                                        scanner.nextLine(); 

                                        if (productChoice == 1) {
                                            
                                            System.out.print("Enter product name: ");
                                            String productName = scanner.nextLine();
                                            System.out.print("Enter product description: ");
                                            String productDescription = scanner.nextLine();
                                            System.out.print("Enter product price: ");
                                            double productPrice = scanner.nextDouble();
                                            System.out.print("Enter product stock: ");
                                            int productQuantity = scanner.nextInt();
                                            scanner.nextLine(); 

                                            String addStatus = productService.addProduct(productName, productDescription, productPrice, productQuantity);
                                            System.out.println(addStatus);
                                        } else if (productChoice == 2) {
                                            
                                            System.out.println("\n--- Product List ---");
                                            productService.viewProducts();

                                        } else if (productChoice == 3) {
                                            
                                            System.out.print("Enter product ID to update: ");
                                            int productId = scanner.nextInt();
                                            scanner.nextLine(); 
                                            System.out.print("Enter new product name: ");
                                            String newName = scanner.nextLine();
                                            System.out.print("Enter new product description: ");
                                            String newDescription = scanner.nextLine();
                                            System.out.print("Enter new product price: ");
                                            double newPrice = scanner.nextDouble();
                                            System.out.print("Enter new product stock: ");
                                            int newQuantity = scanner.nextInt();
                                            scanner.nextLine(); 

                                            String updateStatus = productService.updateProduct(productId, newName, newDescription, newPrice, newQuantity);
                                            System.out.println(updateStatus);
                                        } else if (productChoice == 4) {
                                            // Delete Product
                                            System.out.print("Enter product ID to delete: ");
                                            int deleteProductId = scanner.nextInt();
                                            scanner.nextLine(); 

                                            String deleteStatus = productService.deleteProduct(deleteProductId);
                                            System.out.println(deleteStatus);
                                        } else if (productChoice == 5) {
                                            // Back to Admin Menu
                                            break;
                                        } else {
                                            System.out.println("Invalid choice. Please try again.");
                                        }
                                    }
                                } else if (adminChoice == 3) {
                                    // Logout
                                    System.out.println("Logging out...");
                                    break;
                                } else {
                                    System.out.println("Invalid choice. Try again.");
                                }
                            }
                        } else {
                            // Regular user menu
                            while (true) {
                                System.out.println("\n--- User Menu ---");
                                System.out.println("1. View Products");
                                System.out.println("2. Manage Cart");
                                System.out.println("3. Logout");
                                System.out.println("4. Search Products");
                                System.out.print("Choose an option: ");
                                int userChoice = scanner.nextInt();
                                scanner.nextLine(); 

                                if (userChoice == 1) {
                                    System.out.println("\n--- Product List ---");
                                    productService.viewProducts();
                                } else if (userChoice == 2) {
                                    // Cart Management
                                    while (true) {
                                        System.out.println("\n--- Cart Menu ---");
                                        System.out.println("1. Add Product to Cart");
                                        System.out.println("2. View Cart");
                                        System.out.println("3. Remove Product from Cart");
                                        System.out.println("4. Place Order");
                                        System.out.println("5. Back to User Menu");
                                        System.out.print("Choose an option: ");
                                        int cartChoice = scanner.nextInt();

                                        if (cartChoice == 1) {
                                            System.out.print("Enter Product ID: ");
                                            int productId = scanner.nextInt();
                                            System.out.print("Enter Quantity: ");
                                            int quantity = scanner.nextInt();

                                            Product product = productService.findProductById(productId);
                                            if (product == null) {
                                                System.out.println("Product not found.");
                                            } else {
                                                System.out.println(cartService.addToCart(product, quantity));
                                            }
                                        } else if (cartChoice == 2) {
                                            cartService.viewCart();
                                        } else if (cartChoice == 3) {
                                            System.out.print("Enter Product ID to remove: ");
                                            int productId = scanner.nextInt();
                                            System.out.println(cartService.removeFromCart(productId));
                                        } else if (cartChoice == 4) {
                                        	cartService.viewCart();
                                            cartService.placeOrder();
                                        } else if (cartChoice == 5) {
                                            break; 
                                        } else {
                                            System.out.println("Invalid choice. Try again.");
                                        }
                                    }
                                } else if (userChoice == 3) {
                                    
                                    System.out.println("Logging out...");
                                    break;
                                }else if (userChoice == 4) {
                                    System.out.print("Enter product name to search: ");
                                    String productName = scanner.nextLine();
                                    List<Product> searchResults = productService.searchProductsByName(productName);

                                    if (searchResults.isEmpty()) {
                                        System.out.println("No products found matching the name: " + productName);
                                    } else {
                                        System.out.println("\n--- Search Results ---");
                                        System.out.printf("%-5s %-20s %-30s %-10s %-10s\n", "ID", "Name", "Description", "Price", "Stock");
                                        System.out.println("--------------------------------------------------------------------------");

                                        for (Product product : searchResults) {
                                            System.out.printf("%-5d %-20s %-30s %-10.2f %-10d\n",
                                                    product.getId(),
                                                    product.getName(),
                                                    product.getDescription(),
                                                    product.getPrice(),
                                                    product.getQuantity());
                                        }
                                    }

                                }else {
                                    System.out.println("Invalid choice. Try again.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;

                case 3: // Exit
                    System.out.println("Thank you for using the E-Commerce Backend System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
