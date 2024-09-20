package model;

public class Notification {
    private String message;
    private String type; // e.g., 'RoomDirty' or 'RoomAssigned'
    private String timestamp;

    // Constructor
    public Notification(String message, String type, String timestamp) {
        this.message = message;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Notification() {
    }
    
    

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
