package projectsrc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService(); // For user management
        ProductService productService = new ProductService(); // For product management
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- E-Commerce Backend System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                            // Admin-specific menu
                            while (true) {
                                System.out.println("\n--- Admin Menu ---");
                                System.out.println("1. View All Users");
                                System.out.println("2. Manage Products");
                                System.out.println("3. Logout");
                                System.out.print("Choose an option: ");
                                int adminChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                if (adminChoice == 1) {
                                    System.out.println("Registered Users:");
                                    for (User registeredUser : userService.getAllUsers()) {
                                        System.out.println(registeredUser);
                                    }
                                } else if (adminChoice == 2) {
                                    // Product Management
                                    while (true) {
                                        System.out.println("\n--- Product Management ---");
                                        System.out.println("1. Add Product");
                                        System.out.println("2. View Products");
                                        System.out.println("3. Update Product");
                                        System.out.println("4. Delete Product");
                                        System.out.println("5. Back to Admin Menu");
                                        System.out.print("Choose an option: ");
                                        int productChoice = scanner.nextInt();
                                        scanner.nextLine(); // Consume newline

                                        if (productChoice == 1) {
                                            // Add Product
                                            System.out.print("Enter product name: ");
                                            String productName = scanner.nextLine();
                                            System.out.print("Enter product description: ");
                                            String productDescription = scanner.nextLine();
                                            System.out.print("Enter product price: ");
                                            double productPrice = scanner.nextDouble();
                                            System.out.print("Enter product stock: ");
                                            int productQuantity = scanner.nextInt();
                                            scanner.nextLine(); // Consume newline

                                            String addStatus = productService.addProduct(productName, productDescription, productPrice, productQuantity);
                                            System.out.println(addStatus);
                                        } else if (productChoice == 2) {
                                            // View Products
                                            System.out.println("\n--- Product List ---");
                                            productService.viewProducts();
                                            
                                        } else if (productChoice == 3) {
                                            // Update Product
                                            System.out.print("Enter product ID to update: ");
                                            int productId = scanner.nextInt();
                                            scanner.nextLine(); // Consume newline
                                            System.out.print("Enter new product name: ");
                                            String newName = scanner.nextLine();
                                            System.out.print("Enter new product description: ");
                                            String newDescription = scanner.nextLine();
                                            System.out.print("Enter new product price: ");
                                            double newPrice = scanner.nextDouble();
                                            System.out.print("Enter new product stock: ");
                                            int newQuantity = scanner.nextInt();
                                            scanner.nextLine(); // Consume newline

                                            String updateStatus = productService.updateProduct(productId, newName, newDescription, newPrice, newQuantity);
                                            System.out.println(updateStatus);
                                        } else if (productChoice == 4) {
                                            // Delete Product
                                            System.out.print("Enter product ID to delete: ");
                                            int deleteProductId = scanner.nextInt();
                                            scanner.nextLine(); // Consume newline

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
                            System.out.println("You are logged in as a regular user.");
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
