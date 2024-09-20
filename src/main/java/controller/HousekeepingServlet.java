package controller;

import service.RoomDAO;
import service.UserDAO;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Notification;
import model.User;

public class HousekeepingServlet extends HttpServlet {

    private RoomDAO roomDAO;
    private UserDAO userDAO;

    public void init() {
        roomDAO = new RoomDAO();
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Fetch all rooms
        List<Room> listRooms = roomDAO.getAllRooms();
        request.setAttribute("listRooms", listRooms);

        // Fetch all room boys
        List<User> listRoomBoys = userDAO.getRoomBoys();
        request.setAttribute("listRoomBoys", listRoomBoys);
        
        // Fetch all assigned room boys
        List<Integer> assignedRoomBoys = roomDAO.getAssignedRoomBoys();
        request.setAttribute("assignedRoomBoys", assignedRoomBoys);
        
        // Ensure the session has a notifications list
        HttpSession session = request.getSession();
        if (session.getAttribute("notifications") == null) {
            session.setAttribute("notifications", new ArrayList<Notification>());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/housekeepingDashboard.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomNumber = request.getParameter("roomNumber");
        roomDAO.updateRoomStatus(roomNumber, "Dirty");
        userDAO.sendSMSToHeadRoomBoy(roomNumber);
        response.sendRedirect("HousekeepingServlet");
    }
}
