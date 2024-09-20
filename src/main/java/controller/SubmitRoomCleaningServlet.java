package controller;

import service.RoomCleaningReportDAO;
import service.RoomDAO;
import service.NotificationDAO;
import service.InventoryDAO;
import model.Notification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SubmitRoomCleaningServlet extends HttpServlet {

    private RoomCleaningReportDAO reportDAO;
    private RoomDAO roomDAO;
    private InventoryDAO inventoryDAO;
    private NotificationDAO notificationDAO;

    public void init() {
        reportDAO = new RoomCleaningReportDAO();
        roomDAO = new RoomDAO();
        inventoryDAO = new InventoryDAO();  // Initialize InventoryDAO
        notificationDAO = new NotificationDAO();  // Initialize NotificationDAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters
        String roomNumber = request.getParameter("roomNumber");
        String roomBoyIdStr = request.getParameter("roomBoyId");

        // Validate roomBoyId
        if (roomBoyIdStr == null || roomBoyIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Room Boy ID is missing or invalid.");
            return;
        }

        int roomBoyId;
        try {
            roomBoyId = Integer.parseInt(roomBoyIdStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Room Boy ID format.");
            return;
        }

        // Ensure roomNumber is not null
        if (roomNumber == null || roomNumber.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Room Number is missing or invalid.");
            return;
        }

        // Process form inputs
        String forgottenItems = request.getParameter("forgottenItems");
        String damages = request.getParameter("damages");

        boolean cleanBathroom = request.getParameter("cleanBathroom") != null;
        boolean dustSurfaces = request.getParameter("dustSurfaces") != null;
        boolean vacuumMopFloor = request.getParameter("vacuumMopFloor") != null;
        boolean cleanMirrorsWindows = request.getParameter("cleanMirrorsWindows") != null;
        boolean changeLinens = request.getParameter("changeLinens") != null;
        boolean emptyTrashBins = request.getParameter("emptyTrashBins") != null;

        int removedTowels = Integer.parseInt(request.getParameter("removedTowels"));
        int removedBedsheets = Integer.parseInt(request.getParameter("removedBedsheets"));
        int removedPillowcases = Integer.parseInt(request.getParameter("removedPillowcases"));
        int removedBlankets = Integer.parseInt(request.getParameter("removedBlankets"));

        int replacedTowels = Integer.parseInt(request.getParameter("replacedTowels"));
        int replacedBedsheets = Integer.parseInt(request.getParameter("replacedBedsheets"));
        int replacedPillowcases = Integer.parseInt(request.getParameter("replacedPillowcases"));
        int replacedBlankets = Integer.parseInt(request.getParameter("replacedBlankets"));

        int soapQuantity = Integer.parseInt(request.getParameter("soap"));

        try {
            // Save the cleaning report
            reportDAO.saveCleaningReport(
                roomNumber, roomBoyId, forgottenItems, damages, cleanBathroom, dustSurfaces, vacuumMopFloor,
                cleanMirrorsWindows, changeLinens, replacedTowels, replacedBedsheets, replacedPillowcases,
                replacedBlankets, removedTowels, removedBedsheets, removedPillowcases, removedBlankets, 
                soapQuantity, emptyTrashBins
            );

            // Update laundry inventory (add removed items)
            inventoryDAO.updateLaundryInventory("Towels", removedTowels);
            inventoryDAO.updateLaundryInventory("Bedsheets", removedBedsheets);
            inventoryDAO.updateLaundryInventory("Pillowcases", removedPillowcases);
            inventoryDAO.updateLaundryInventory("Blankets", removedBlankets);

            // Update fresh linen inventory (subtract replaced items)
            inventoryDAO.updateFreshLinenInventory("Towels", replacedTowels);
            inventoryDAO.updateFreshLinenInventory("Bedsheets", replacedBedsheets);
            inventoryDAO.updateFreshLinenInventory("Pillowcases", replacedPillowcases);
            inventoryDAO.updateFreshLinenInventory("Blankets", replacedBlankets);

            // Update toiletries inventory (subtract soap used)
            inventoryDAO.updateToiletriesInventory("Soap", soapQuantity);

            // Update room status to "Vacant"
            roomDAO.updateRoomStatus(roomNumber, "Vacant");

            // Unassign the room boy from the room
            roomDAO.unassignRoomBoy(roomNumber);

            // Create a notification for the head room boy
            String message = "Room " + roomNumber + " has been cleaned and is now vacant.";
            String type = "RoomCleaningCompleted";
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Notification notification = new Notification(message, type, formattedDate);
            notificationDAO.saveNotification(notification);

            // Respond with success
            response.getWriter().println("Cleaning report submitted successfully! The room status has been updated to Vacant.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }
}
