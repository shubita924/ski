package Objects;


import java.sql.Timestamp;

public class User {
    private long id;
    private String email;
    private String fullName;
    private String salt;
    private String passwordHash;
    private String role;
    private Timestamp createdAt;
    private String phone;


    // Constructor for inserting
    public User(String email, String fullName, String salt, String passwordHash, String role, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.salt = salt;
        this.passwordHash = passwordHash;
        this.role = role;
        this.phone = phone;
    }

    // Constructor for fetching from DB
    public User(int id, String email, String fullName, String salt, String passwordHash,
                String role, Timestamp createdAt, String phone) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.salt = salt;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = createdAt;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}