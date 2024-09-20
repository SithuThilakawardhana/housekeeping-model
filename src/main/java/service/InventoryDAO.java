package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/hotel_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "cloudslt@123";
    
    // Load MySQL JDBC driver explicitly
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }
    }

    // Update laundry inventory (add removed items)
    public void updateLaundryInventory(String itemName, int quantity) {
        String sql = "UPDATE laundry_inventory SET quantity = quantity + ? WHERE item_name = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, itemName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update fresh linen inventory (subtract replaced items)
    public void updateFreshLinenInventory(String itemName, int quantity) {
        String sql = "UPDATE fresh_linen_inventory SET quantity = quantity - ? WHERE item_name = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, itemName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update toiletries inventory
    public void updateToiletriesInventory(String itemName, int quantity) {
        String sql = "UPDATE toiletries_inventory SET quantity = quantity - ? WHERE item_name = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, itemName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


