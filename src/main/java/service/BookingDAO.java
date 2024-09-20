package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Booking;

public class BookingDAO {
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
    
    // Fetch all open bookings
    public List<Booking> getOpenBookings() {
        List<Booking> openBookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE bill_status = 'Open'";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setRoomNumber(rs.getString("room_number"));
                booking.setCustomerName(rs.getString("customer_name"));
                booking.setCheckInDate(rs.getTimestamp("check_in_date").toLocalDateTime());
                booking.setCheckOutDate(rs.getTimestamp("check_out_date").toLocalDateTime());
                booking.setBillStatus(rs.getString("bill_status"));
                openBookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return openBookings;
    }

    // Method to close the bill for a specific room
    public void closeBillForRoom(String roomNumber) {
        String sql = "UPDATE bookings SET bill_status = 'Closed' WHERE room_number = ? AND bill_status = 'Open'";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, roomNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
