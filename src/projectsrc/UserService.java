package projectsrc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

//    private Connection connection;
	
    private List<User> users = new ArrayList<>();

    public UserService() {
    	
    	
    	User admin = new User("admin", "admin123", "admin@example.com");
       users.add(admin);
        User user = new User("user1","user123","user1@gmail.com");
       users.add(user);
    
//        try {
//          
//        	connection = DatabaseConnection.getConnection();
//        } catch (SQLException e) {
//            e.getMessage();
//            throw new RuntimeException("Failed to connect to the database.");
//        }
    }

    // Register a new user
    public String registerUser(String username, String password, String email) {
    	
        
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return "Username already exists. Please choose another.";
            }
        }
        
        users.add(new User(username, password, email));
        return "User registered successfully!";
    	
    	
//        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
//        String checkQuery = "SELECT * FROM users WHERE username = ?";
//
//        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
//             PreparedStatement stmt = connection.prepareStatement(query)) {
//
//            // Check if the username already exists
//            checkStmt.setString(1, username);
//            ResultSet rs = checkStmt.executeQuery();
//            if (rs.next()) {
//                return "Username already exists. Please choose another.";
//            }
//
//            // Insert the new user
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//            stmt.setString(3, email);
//            stmt.executeUpdate();
//
//            return "User registered successfully!";
//        } catch (SQLException e) {
//            e.getMessage();
//            return "Error occurred during registration: " + e.getMessage();
//        }
    }

    // Login a user
    public User loginUser(String username, String password) {
    	for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user; 
            }
       }
        return null; 
   	
    	
    	
//    	
//        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return new User(
//                    rs.getString("username"),
//                    rs.getString("password"),
//                    rs.getString("email")
//                );
//            }
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//
//        return null; 
    }

    // Get all users
    public List<User> getAllUsers() {
       
        return users;
        
//        String query = "SELECT * FROM users";
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                users.add(new User(
//                    rs.getString("username"),
//                    rs.getString("password"),
//                    rs.getString("email")
//                ));
//            }
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//
//        return users;
   }
}
