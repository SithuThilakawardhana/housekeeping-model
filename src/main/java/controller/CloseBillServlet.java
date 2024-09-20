package controller;

import service.BookingDAO;
import model.Booking;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class CloseBillServlet extends HttpServlet {
    private BookingDAO bookingDAO;

    public void init() {
        bookingDAO = new BookingDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get all open bookings
        List<Booking> openBookings = bookingDAO.getOpenBookings();
        request.setAttribute("openBookings", openBookings);

        // Forward to the JSP page to display the bookings
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/closeBill.jsp");
        dispatcher.forward(request, response);
    }
}
