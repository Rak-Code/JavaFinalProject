package projectsrc;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    // Static admin user
    public UserService() {
        // Initialize with a default admin user
        User admin = new User("admin", "admin123", "admin@example.com");
        users.add(admin);
    }

    // Register a new user
    public String registerUser(String username, String password, String email) {
        // Check if the username already exists
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return "Username already exists. Please choose another.";
            }
        }
        // Add the user to the list
        users.add(new User(username, password, email));
        return "User registered successfully!";
    }

    // Authenticate a user (login)
    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user; 
            }
        }
        return null; 
    }

    // Get all users (admin feature)
    public List<User> getAllUsers() {
        return users;
    }
}
