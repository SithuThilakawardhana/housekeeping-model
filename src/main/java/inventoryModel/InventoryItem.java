package inventoryModel;

public class InventoryItem {
    private int id;
    private String itemName;
    private int quantity;

    public InventoryItem(int id, String itemName, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public InventoryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
    
    

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
