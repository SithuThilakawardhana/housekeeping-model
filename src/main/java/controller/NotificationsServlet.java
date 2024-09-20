package controller;

import model.Notification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import service.NotificationDAO;

public class NotificationsServlet extends HttpServlet {

    private NotificationDAO notificationDAO;

    public void init() {
        notificationDAO = new NotificationDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch notifications from the database
        List<Notification> notifications = notificationDAO.getAllNotifications();

        // Forward the notifications to the JSP
        request.setAttribute("notifications", notifications);
        request.getRequestDispatcher("views/notifications.jsp").forward(request, response);
    }
}
