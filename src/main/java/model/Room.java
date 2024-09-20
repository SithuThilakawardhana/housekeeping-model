package model;

public class Room {
    private String roomNumber;
    private String status;
    private Integer roomBoyId; // Field to store the assigned room boy's ID

    public Room(String roomNumber, String status, Integer roomBoyId) {
        this.roomNumber = roomNumber;
        this.status = status;
        this.roomBoyId = roomBoyId;
    }

    public Room() {
    }
    
    

    // Getter and Setter for roomNumber
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for roomBoyId
    public Integer getRoomBoyId() {
        return roomBoyId;
    }

    public void setRoomBoyId(Integer roomBoyId) {
        this.roomBoyId = roomBoyId;
    }
}

