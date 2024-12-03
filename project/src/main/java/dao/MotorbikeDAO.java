package dao;

import model.Motorbike;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorbikeDAO {
    private Connection conn;

    public MotorbikeDAO(Connection conn) {
        this.conn = conn;
    }

    public void addMotorbike(int userId, String make, String model) throws SQLException {
        String query = "INSERT INTO MOTORBIKE (make, model, user_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, make);
        stmt.setString(2, model);
        stmt.setInt(3, userId);
        stmt.executeUpdate();
    }

    public void updateMotorbike(int motorbikeId, int userId, String make, String model) throws SQLException {
        String query = "UPDATE MOTORBIKE SET make = ?, model = ? WHERE id = ? AND user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, make);
        stmt.setString(2, model);
        stmt.setInt(3, motorbikeId);
        stmt.setInt(4, userId);
        stmt.executeUpdate();
    }

    public void deleteMotorbike(int motorbikeId, int userId) throws SQLException {
        String query = "DELETE FROM MOTORBIKE WHERE id = ? AND user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, motorbikeId);
        stmt.setInt(2, userId);
        stmt.executeUpdate();
    }

    public String[] getMotorbikeById(int motorbikeId, int userId) throws SQLException {
        String query = "SELECT make, model FROM MOTORBIKE WHERE id = ? AND user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, motorbikeId);
        stmt.setInt(2, userId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new String[] { rs.getString("make"), rs.getString("model") };
        }
        return null;
    }

    public List<Motorbike> getUserMotorbikes(int userId) throws SQLException {
        List<Motorbike> motorbikes = new ArrayList<>();
        String query = "SELECT id, make, model FROM MOTORBIKE WHERE user_id = ?";
        System.out.println("Executing query: " + query); // Debug log
        
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String make = rs.getString("make");
            String model = rs.getString("model");
            motorbikes.add(new Motorbike(id, make, model, userId)); 
        }
        return motorbikes;
    }


    public List<String> getAllMotorbikes() throws SQLException {
        List<String> motorbikes = new ArrayList<>();
        String query = "SELECT make, model FROM MOTORBIKE";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            motorbikes.add(rs.getString("make") + " " + rs.getString("model"));
        }
        return motorbikes;
    }
}
