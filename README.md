# E-Commerce Backend System Documentation

## Project Overview
The E-Commerce Backend System is a console-based application designed to simulate the functionality of an e-commerce platform. It includes user management, product management, and cart management, providing a foundational structure for building a more extensive system in the future.

---

## Project Features

### Current Features
1. **User Management**:
   - Registration of new users.
   - Login functionality with role differentiation (admin and regular users).
   - Predefined users for convenience.
2. **Product Management** (Admin):
   - Add new products.
   - View all products.
   - Update existing products.
   - Delete products.
   - Search products by name (accessible by all users).
3. **Cart Management** (User):
   - Add products to the cart.
   - View cart contents.
   - Remove products from the cart.
   - Place orders.

### Future Enhancements
1. **Security**:
   - Implement password hashing for secure user authentication.
   - Introduce session management for secure and persistent user sessions.
2. **Error Handling**:
   - Comprehensive exception handling to ensure system stability.
   - Detailed error messages for better debugging.
3. **Database Integration**:
   - Replace in-memory lists with a database for persistent data storage.
   - Use JDBC and MySQL for database operations.
4. **Improved Search**:
   - Add filters for price range, category, and stock availability.
5. **Product Categories**:
   - Organize products into categories for better navigation.
6. **Order Management**:
   - Maintain order history for users.
   - Allow order cancellations and returns.
7. **Payment Gateway Simulation**:
   - Integrate a basic payment gateway simulation.
8. **Admin Dashboard**:
   - Enhanced admin functionality with analytics and reports.

---

## Project Flow

### Main Menu
1. **Register**: Allows new users to register.
2. **Login**: Enables existing users to log in as either admin or regular users.
3. **Exit**: Exits the application.

### Admin Menu
1. **View All Users**: Lists all registered users.
2. **Manage Products**: Provides options to add, view, update, and delete products.
3. **Logout**: Logs out the admin and returns to the main menu.

### User Menu
1. **View Products**: Displays a list of available products.
2. **Manage Cart**:
   - Add products to the cart.
   - View cart contents.
   - Remove products from the cart.
   - Place orders.
3. **Search Products**: Searches products by name.
4. **Logout**: Logs out the user and returns to the main menu.

---

## Class and Entity Descriptions

### Class: `Main`
- Entry point of the application.
- Manages the overall flow of the program, including menu navigation.

### Class: `UserService`
- Handles user registration and login.
- Maintains a list of registered users.
- Predefines an admin and a regular user for convenience.

### Class: `ProductService`
- Manages all product-related operations:
  - Add, update, delete, and view products.
  - Search products by name.
- Stores product data in a list.

### Class: `CartService`
- Handles cart-related operations for users:
  - Add products to the cart.
  - View cart contents.
  - Remove products from the cart.
  - Place orders.

### Class: `User`
- Represents a user with attributes:
  - Username
  - Password
  - Email

### Class: `Product`
- Represents a product with attributes:
  - ID
  - Name
  - Description
  - Price
  - Stock quantity
![NoteGPT-Class Diagram-1735763779201](https://github.com/user-attachments/assets/01724d7f-fe01-4766-a80e-399c6cd8bfa7)
### Relationships
1. **User and Cart**:
   - A user can have one cart.
   - Cart is managed independently of the `User` class for scalability.
2. **Admin and Product Management**:
   - Only the admin can add, update, or delete products.
   - Both admin and regular users can view and search for products.
3. **Product and Cart**:
   - Products are added to the cart based on availability.
   - Cart operates on product IDs and quantities.

---

## Updated Features List
1. **Predefined Users**:
   - Added a predefined admin and regular user for easier access.
   - Admin credentials: `admin/admin123`.
   - User credentials: `user1/user123`.
2. **Search Products**:
   - Case-insensitive search based on product names.
3. **View Products**:
   - Enhanced product listing with formatted output.

---

## Example Application Flow

### Scenario: Admin Login
1. **Login**:
   - Enter username: `admin`
   - Enter password: `admin123`
2. **Admin Menu**:
   - Choose "Manage Products".
   - Add a new product: "Sweater" with a price of $30.00 and stock of 20.
   - View the product list to confirm the addition.

### Scenario: User Login
1. **Login**:
   - Enter username: `user1`
   - Enter password: `user123`
2. **User Menu**:
   - Search for "T-Shirt".
   - Add it to the cart.
   - View the cart to confirm.
   - Place an order.

---

## Future Development Checklist
1. **Security Enhancements**:
   - Password hashing with libraries like BCrypt.
   - Role-based access control.
2. **Performance Improvements**:
   - Implement caching for frequently accessed data.
   - Optimize search functionality.
3. **User Experience**:
   - Implement a web-based front-end interface.
   - Support for multiple languages.
4. **Testing**:
   - Add unit and integration tests for all modules.
5. **API Development**:
   - Build REST APIs to make the system accessible via HTTP requests.

---

## Conclusion
This E-Commerce Backend System is a scalable and extensible framework for managing users, products, and orders. While currently a console-based application, its design facilitates future integration with advanced features, databases, and a web-based interface.


