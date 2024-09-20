package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomCleaningReportDAO {
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

    public void saveCleaningReport(String roomNumber, int roomBoyId, String forgottenItems, String damages,
                                   boolean cleanBathroom, boolean dustSurfaces, boolean vacuumMopFloor, 
                                   boolean cleanMirrorsWindows, boolean changeLinens, int replacedTowels, 
                                   int replacedBedsheets, int replacedPillowcases, int replacedBlankets, 
                                   int removedTowels, int removedBedsheets, int removedPillowcases, 
                                   int removedBlankets, int soapQuantity, boolean emptyTrashBins) {
        String sql = "INSERT INTO room_cleaning_reports (room_number, room_boy_id, forgotten_items, damages, " +
                     "clean_bathroom, dust_surfaces, vacuum_mop_floor, clean_mirrors_windows, change_linens, " +
                     "replaced_towels, replaced_bedsheets, replaced_pillowcases, replaced_blankets, removed_towels, " +
                     "removed_bedsheets, removed_pillowcases, removed_blankets, soap_quantity, empty_trash_bins) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, roomNumber);
            preparedStatement.setInt(2, roomBoyId);
            preparedStatement.setString(3, forgottenItems);
            preparedStatement.setString(4, damages);
            preparedStatement.setBoolean(5, cleanBathroom);
            preparedStatement.setBoolean(6, dustSurfaces);
            preparedStatement.setBoolean(7, vacuumMopFloor);
            preparedStatement.setBoolean(8, cleanMirrorsWindows);
            preparedStatement.setBoolean(9, changeLinens);
            preparedStatement.setInt(10, replacedTowels);
            preparedStatement.setInt(11, replacedBedsheets);
            preparedStatement.setInt(12, replacedPillowcases);
            preparedStatement.setInt(13, replacedBlankets);
            preparedStatement.setInt(14, removedTowels);
            preparedStatement.setInt(15, removedBedsheets);
            preparedStatement.setInt(16, removedPillowcases);
            preparedStatement.setInt(17, removedBlankets);
            preparedStatement.setInt(18, soapQuantity);
            preparedStatement.setBoolean(19, emptyTrashBins);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
