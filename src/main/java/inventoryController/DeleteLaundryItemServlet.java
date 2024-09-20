package inventoryController;

import inventoryService.InventoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteLaundryItemServlet extends HttpServlet {

    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        inventoryDAO.deleteLaundryItemById(id);
        response.sendRedirect("LaundryInventoryServlet");
    }
}
