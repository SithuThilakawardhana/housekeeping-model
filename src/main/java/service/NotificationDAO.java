package service;

import model.Notification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/hotel_management";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "cloudslt@123";

    // Load MySQL JDBC driver explicitly
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }
    }

    // Save a Notification object to the database
    public void saveNotification(Notification notification) {
        String sql = "INSERT INTO notifications (message, type, timestamp) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, notification.getMessage());
            preparedStatement.setString(2, notification.getType());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(notification.getTimestamp()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving notification: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Fetch all notifications from the database
    public List<Notification> getAllNotifications() {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications ORDER BY timestamp DESC";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Notification notification = new Notification(
                        rs.getString("message"),
                        rs.getString("type"),
                        rs.getTimestamp("timestamp").toString() // Format the timestamp as needed
                );
                notifications.add(notification);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching notifications: " + e.getMessage());
            e.printStackTrace();
        }
        return notifications;
    }
}
