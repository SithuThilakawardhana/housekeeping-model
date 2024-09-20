package controller;

import service.RoomDAO;
import service.BookingDAO;
import service.UserDAO;
import service.NotificationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Notification;


public class BillClosureServlet extends HttpServlet {
    private RoomDAO roomDAO;
    private BookingDAO bookingDAO;
    private UserDAO userDAO;
    private NotificationDAO notificationDAO;

    public void init() {
        roomDAO = new RoomDAO();
        bookingDAO = new BookingDAO();
        userDAO = new UserDAO();
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Log the start of the request processing
        System.out.println("BillClosureServlet triggered");

        // Get the room number from the request
        String roomNumber = request.getParameter("roomNumber");
        System.out.println("Received request to close bill for room: " + roomNumber);

        // Close the bill (set the bill status to "Closed")
        bookingDAO.closeBillForRoom(roomNumber);
        System.out.println("Bill closed for room: " + roomNumber);

        // Update the room status to "Dirty"
        roomDAO.updateRoomStatus(roomNumber, "Dirty");
        System.out.println("Room status updated to Dirty for room: " + roomNumber);

        // Send an SMS to the head room boy
        userDAO.sendSMSToHeadRoomBoy(roomNumber);
        System.out.println("SMS sent to head room boy for room: " + roomNumber);

        // Generate a notification and save it to the database
        String message = "Room " + roomNumber + " is now dirty.";
        String type = "RoomDirty";
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Notification notification = new Notification(message, type, formattedDate);
        notificationDAO.saveNotification(notification);

        // Redirect to the housekeeping dashboard
        response.sendRedirect(request.getContextPath() + "/HousekeepingServlet");
    }
}

