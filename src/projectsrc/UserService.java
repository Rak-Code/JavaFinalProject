package projectsrc;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

  
    public UserService() {
        
        User admin = new User("admin", "admin123", "admin@example.com");
        users.add(admin);
    }


    public String registerUser(String username, String password, String email) {
        
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return "Username already exists. Please choose another.";
            }
        }
        
        users.add(new User(username, password, email));
        return "User registered successfully!";
    }

   
    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user; 
            }
        }
        return null; 
    }


    public List<User> getAllUsers() {
        return users;
    }
}
