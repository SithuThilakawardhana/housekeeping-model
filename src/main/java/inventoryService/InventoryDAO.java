package inventoryService;

import inventoryModel.InventoryItem;
import inventoryModel.LaundryTransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    // Get Fresh Linen Inventory
    public List<InventoryItem> getFreshLinenInventory() {
        String sql = "SELECT * FROM fresh_linen_inventory";
        return getInventoryItems(sql);
    }

    // Add a new item to fresh linen inventory
    public void addFreshLinenItem(InventoryItem item) {
        String sql = "INSERT INTO fresh_linen_inventory (item_name, quantity) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing fresh linen item
    public void updateFreshLinenItem(InventoryItem item) {
        String sql = "UPDATE fresh_linen_inventory SET item_name = ?, quantity = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.setInt(3, item.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a fresh linen item by ID
    public void deleteFreshLinenItemById(int id) {
        String sql = "DELETE FROM fresh_linen_inventory WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a specific fresh linen item by ID
    public InventoryItem getFreshLinenItemById(int id) {
        String sql = "SELECT * FROM fresh_linen_inventory WHERE id = ?";
        InventoryItem item = null;

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                item = new InventoryItem(rs.getInt("id"), rs.getString("item_name"), rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    // Get Laundry Inventory
    public List<InventoryItem> getLaundryInventory() {
        String sql = "SELECT * FROM laundry_inventory";
        return getInventoryItems(sql);
    }

    // Add a new item to laundry inventory
    public void addLaundryItem(InventoryItem item) {
        String sql = "INSERT INTO laundry_inventory (item_name, quantity) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing laundry item
    public void updateLaundryItem(InventoryItem item) {
        String sql = "UPDATE laundry_inventory SET item_name = ?, quantity = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.setInt(3, item.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a laundry item by ID
    public void deleteLaundryItemById(int id) {
        String sql = "DELETE FROM laundry_inventory WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a specific laundry item by ID
    public InventoryItem getLaundryItemById(int id) {
        String sql = "SELECT * FROM laundry_inventory WHERE id = ?";
        InventoryItem item = null;

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                item = new InventoryItem(rs.getInt("id"), rs.getString("item_name"), rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    // Get Toiletries Inventory
    public List<InventoryItem> getToiletriesInventory() {
        String sql = "SELECT * FROM toiletries_inventory";
        return getInventoryItems(sql);
    }

    // Add a new item to toiletries inventory
    public void addToiletriesItem(InventoryItem item) {
        String sql = "INSERT INTO toiletries_inventory (item_name, quantity) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the parameters for the new item (name and quantity)
            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing toiletries item
    public void updateToiletriesItem(InventoryItem item) {
        String sql = "UPDATE toiletries_inventory SET item_name = ?, quantity = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.setInt(3, item.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an item from toiletries inventory by ID
    public void deleteToiletriesItemById(int id) {
        String sql = "DELETE FROM toiletries_inventory WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a specific toiletries item by ID
    public InventoryItem getToiletriesItemById(int id) {
        String sql = "SELECT * FROM toiletries_inventory WHERE id = ?";
        InventoryItem item = null;

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                item = new InventoryItem(rs.getInt("id"), rs.getString("item_name"), rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    // Helper method to fetch inventory items
    private List<InventoryItem> getInventoryItems(String sql) {
        List<InventoryItem> inventoryItems = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // Fetch id, itemName, and quantity from the result set
                int id = rs.getInt("id"); // Assuming you have an 'id' column in your table
                String itemName = rs.getString("item_name");
                int quantity = rs.getInt("quantity");

                // Create a new InventoryItem using the constructor with id, itemName, and quantity
                InventoryItem item = new InventoryItem(id, itemName, quantity);
                inventoryItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryItems;
    }

    // Update laundry inventory after linens are sent to washer
    public void updateLaundryInventoryAfterSent(int towels, int bedsheets, int pillowcases, int blankets) {
        String sql = "UPDATE laundry_inventory SET quantity = quantity - ? WHERE item_name = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Update towels in laundry inventory
            preparedStatement.setInt(1, towels);
            preparedStatement.setString(2, "Towels");  // Correct item_name as per your DB
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Towels updated: " + rowsAffected + " rows affected");

            // Update bedsheets in laundry inventory
            preparedStatement.setInt(1, bedsheets);
            preparedStatement.setString(2, "Bedsheets");  // Correct item_name
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Bedsheets updated: " + rowsAffected + " rows affected");

            // Update pillowcases in laundry inventory
            preparedStatement.setInt(1, pillowcases);
            preparedStatement.setString(2, "Pillowcases");  // Correct item_name
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Pillowcases updated: " + rowsAffected + " rows affected");

            // Update blankets in laundry inventory
            preparedStatement.setInt(1, blankets);
            preparedStatement.setString(2, "Blankets");  // Correct item_name
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Blankets updated: " + rowsAffected + " rows affected");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update fresh linen inventory after linens are returned from washer
    // Update fresh linen inventory after linens are returned from washer
    public void updateFreshLinenInventoryAfterReturn(int towels, int bedsheets, int pillowcases, int blankets) {
        String sql = "UPDATE fresh_linen_inventory SET quantity = quantity + ? WHERE item_name = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Update towels in fresh linen inventory
            preparedStatement.setInt(1, towels);
            preparedStatement.setString(2, "Towels");  // Correct item_name
            preparedStatement.executeUpdate();

            // Update bedsheets in fresh linen inventory
            preparedStatement.setInt(1, bedsheets);
            preparedStatement.setString(2, "Bedsheets");  // Correct item_name
            preparedStatement.executeUpdate();

            // Update pillowcases in fresh linen inventory
            preparedStatement.setInt(1, pillowcases);
            preparedStatement.setString(2, "Pillowcases");  // Correct item_name
            preparedStatement.executeUpdate();

            // Update blankets in fresh linen inventory
            preparedStatement.setInt(1, blankets);
            preparedStatement.setString(2, "Blankets");  // Correct item_name
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Record laundry transaction in laundry_transactions table
    public void recordLaundryTransaction(int towels, int bedsheets, int pillowcases, int blankets, String date, String status) {
        String sql = "INSERT INTO laundry_transactions (towel_quantity, bedsheet_quantity, pillowcase_quantity, blanket_quantity, date, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, towels);
            preparedStatement.setInt(2, bedsheets);
            preparedStatement.setInt(3, pillowcases);
            preparedStatement.setInt(4, blankets);
            preparedStatement.setString(5, date);
            preparedStatement.setString(6, status);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LaundryTransaction> getLaundryTransactions() {
        String sql = "SELECT transaction_id, towel_quantity, bedsheet_quantity, pillowcase_quantity, blanket_quantity, date, status FROM laundry_transactions";
        List<LaundryTransaction> transactions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                LaundryTransaction transaction = new LaundryTransaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setTowelQuantity(rs.getInt("towel_quantity"));
                transaction.setBedsheetQuantity(rs.getInt("bedsheet_quantity"));
                transaction.setPillowcaseQuantity(rs.getInt("pillowcase_quantity"));
                transaction.setBlanketQuantity(rs.getInt("blanket_quantity"));
                transaction.setDate(rs.getDate("date"));
                transaction.setStatus(rs.getString("status"));

                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

}
