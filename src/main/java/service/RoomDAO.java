package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Room;

public class RoomDAO {

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
    
    private static final String SELECT_ALL_ROOMS = "SELECT * FROM rooms";
    private static final String SELECT_ALL_ASSIGNED_ROOM_BOYS = "SELECT DISTINCT room_boy_id FROM rooms WHERE room_boy_id IS NOT NULL";


    // Get all rooms
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setRoomNumber(rs.getString("room_number"));
                room.setStatus(rs.getString("status"));
                room.setRoomBoyId(rs.getInt("room_boy_id")); // Get the assigned room boy's ID
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    // Update room status (e.g., from Clean to Dirty)
    public void updateRoomStatus(String roomNumber, String status) {
        String UPDATE_ROOM_STATUS = "UPDATE rooms SET status = ? WHERE room_number = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM_STATUS)) {

            preparedStatement.setString(1, status);
            preparedStatement.setString(2, roomNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update room status and assign room boy
    public void assignRoomBoy(String roomNumber, int roomBoyId) {
        String sql = "UPDATE rooms SET room_boy_id = ? WHERE room_number = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, roomBoyId);
            preparedStatement.setString(2, roomNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Get all assigned room boys
    public List<Integer> getAssignedRoomBoys() {
        List<Integer> assignedRoomBoys = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASSIGNED_ROOM_BOYS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                assignedRoomBoys.add(rs.getInt("room_boy_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignedRoomBoys;
    }
    
    // Method to unassign room boy from a room
    public void unassignRoomBoy(String roomNumber) {
        String sql = "UPDATE rooms SET room_boy_id = NULL WHERE room_number = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, roomNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
