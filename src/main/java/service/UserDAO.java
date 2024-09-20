package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import model.User;
import java.sql.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

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

    // Get the phone number of the head room boy
    public String getHeadRoomBoyPhoneNumber() {
        String sql = "SELECT phone_number FROM users WHERE role = 'head_room_boy'";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("phone_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendSMSToHeadRoomBoy(String roomNumber) {
        String phoneNumber = getHeadRoomBoyPhoneNumber();
        if (phoneNumber != null) {
            String msg = "Room " + roomNumber + " is now dirty and needs cleaning.";
            try {
                // Encode the message to avoid issues with spaces or special characters
                String encodedMessage = URLEncoder.encode(msg, StandardCharsets.UTF_8.toString());

                // Prepare the URL with the encoded message
                String smsUrl = "http://send.ozonedesk.com/api/v2/send.php?user_id=102191&api_key=x63t07ur6q4557pmb"
                        + "&sender_id=Finakle.lk&to=" + phoneNumber + "&message=" + encodedMessage;

                // Debugging logs to see the final URL
                System.out.println("Sending SMS to: " + phoneNumber);
                System.out.println("Encoded URL: " + smsUrl);

                // Send the SMS
                URL url = new URL(smsUrl);
                InputStream is = url.openConnection().getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    System.out.println(responseLine);  // Print the response from the SMS service
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();  // Ensure any errors are logged
            }
        } else {
            System.out.println("Failed to get the phone number for the head room boy.");
        }
    }

    public void sendSMSToRoomBoy(int roomBoyId, String message) {
    String sql = "SELECT phone_number FROM users WHERE user_id = ? AND role = 'room_boy'";
    try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

        preparedStatement.setInt(1, roomBoyId);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            String phoneNumber = rs.getString("phone_number");

            try {
                String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8.toString());
                String smsUrl = "http://send.ozonedesk.com/api/v2/send.php?user_id=102191&api_key=x63t07ur6q4557pmb"
                        + "&sender_id=Finakle.lk&to=" + phoneNumber + "&message=" + encodedMessage;

                // Send the SMS
                URL url = new URL(smsUrl);
                InputStream is = url.openConnection().getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    System.out.println(responseLine);  // Print the response from the SMS service
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();  // Ensure any errors are logged
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Get a list of all room boys
    public List<User> getRoomBoys() {
        List<User> roomBoys = new ArrayList<>();
        String sql = "SELECT user_id, name FROM users WHERE role = 'room_boy'";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                User roomBoy = new User();
                roomBoy.setUserId(rs.getInt("user_id"));
                roomBoy.setName(rs.getString("name"));
                roomBoys.add(roomBoy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomBoys;
    }

    // Get the name of a room boy by their ID
    public String getRoomBoyNameById(int roomBoyId) {
        String sql = "SELECT name FROM users WHERE user_id = ? AND role = 'room_boy'";
        String name = null;

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, roomBoyId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }

}
