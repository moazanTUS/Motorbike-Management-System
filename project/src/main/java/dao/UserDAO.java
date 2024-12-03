package dao;

import java.sql.*;
import java.util.Optional;

public class UserDAO {
    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM USER WHERE name = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    public int registerUser(String name, String password) throws SQLException {
        String query = "INSERT INTO USER (name, password) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, name);
        stmt.setString(2, password);
        stmt.executeUpdate();

        // Retrieve the generated ID
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);  
        } else {
            throw new SQLException("User registration failed, no ID obtained.");
        }
    }

    public Optional<Integer> loginUser(String email, String password) throws SQLException {
        String query = "SELECT id FROM USER WHERE name = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return Optional.of(rs.getInt("id"));
        }
        return Optional.empty();
    }
}
