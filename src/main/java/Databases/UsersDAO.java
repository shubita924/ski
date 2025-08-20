package Databases;

import Objects.User;
import utils.PasswordHasher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    private final String url = "jdbc:mysql://localhost:3306/ski";
    private final String user = "root"; // change if needed
    private final String password = "root"; // change if needed

    public UsersDAO() {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ski", "root", "root");
    }

    // Add new user
    public void addUser(User u) {
        String sql = "INSERT INTO users (email, fullname, salt, passwordhash, role, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getFullName());
            stmt.setString(3, u.getSalt());
            stmt.setString(4, u.getPasswordHash());
            stmt.setString(5, u.getRole());
            stmt.setString(6, u.getPhone());

            stmt.executeUpdate();
            System.out.println("User added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get user by email
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("salt"),
                        rs.getString("passwordhash"),
                        rs.getString("role"),
                        rs.getTimestamp("createdat"),
                        rs.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // not found
    }

    // Get all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("salt"),
                        rs.getString("passwordhash"),
                        rs.getString("role"),
                        rs.getTimestamp("createdat"),
                        rs.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> getAllInstructors() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Instructor"); // only instructors
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    users.add(new User(
                            rs.getInt("id"),
                            rs.getString("email"),
                            rs.getString("fullname"),
                            rs.getString("salt"),
                            rs.getString("passwordhash"),
                            rs.getString("role"),
                            rs.getTimestamp("createdat"),
                            rs.getString("phone")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // In UsersDAO
    public User validateUser(String email, String password) {
        User user = getUserByEmail(email);
        if (user == null) {
            return null; // not found
        }

        // Verify password
        PasswordHasher hasher = new PasswordHasher();

        if (hasher.verifyPassword(password, user.getSalt(), user.getPasswordHash())) {
            return user; // valid login
        } else {
            return null; // wrong password
        }
    }


}
