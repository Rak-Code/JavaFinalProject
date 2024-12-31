package projectsrc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
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
                                System.out.println("2. Logout");
                                System.out.print("Choose an option: ");
                                int adminChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                if (adminChoice == 1) {
                                    System.out.println("Registered Users:");
                                    for (User registeredUser : userService.getAllUsers()) {
                                        System.out.println(registeredUser);
                                    }
                                } else if (adminChoice == 2) {
                                    System.out.println("Logging out...");
                                    break;
                                } else {
                                    System.out.println("Invalid choice. Try again.");
                                }
                            }
                        } else {
                            // User-specific actions (to be implemented later)
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
