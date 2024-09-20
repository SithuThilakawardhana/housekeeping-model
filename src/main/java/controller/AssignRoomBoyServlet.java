package controller;

import service.RoomDAO;
import service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Notification;
import service.NotificationDAO;


public class AssignRoomBoyServlet extends HttpServlet {
    private RoomDAO roomDAO;
    private UserDAO userDAO;
    private NotificationDAO notificationDAO;

    public void init() {
        roomDAO = new RoomDAO();
        userDAO = new UserDAO();
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the room number and selected room boy ID from the request
        String roomNumber = request.getParameter("roomNumber");
        int roomBoyId = Integer.parseInt(request.getParameter("roomBoyId"));

        // Assign the room boy to the room (this method will store the assignment in the DB)
        roomDAO.assignRoomBoy(roomNumber, roomBoyId);

        // Update the room status to "In Progress" or another relevant status
        roomDAO.updateRoomStatus(roomNumber, "In Progress");

        // Generate the room boy's name and the form link
        String roomBoyName = userDAO.getRoomBoyNameById(roomBoyId);
        String formLink = "http://localhost:8080/housekeeping/views/roomCleaningForm.jsp?roomNumber=" + roomNumber + "&roomBoyId=" + roomBoyId;

        // Format the notification string
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String message = "Hi " + roomBoyName + ", you have been assigned to clean room " + roomNumber + 
                         ". Please complete the following form: " + formLink + " (at " + formattedDate + ")";
        System.out.println("Generated form link: " + formLink);

        // Send SMS to the assigned room boy with the form link
        userDAO.sendSMSToRoomBoy(roomBoyId, message);
        
        // Create a notification
        Notification notification = new Notification(message, "RoomAssigned", formattedDate);
        
        // Save the notification to the database
        notificationDAO.saveNotification(notification);
        
        // Redirect back to the housekeeping dashboard
        response.sendRedirect(request.getContextPath() + "/HousekeepingServlet");
    }
}
