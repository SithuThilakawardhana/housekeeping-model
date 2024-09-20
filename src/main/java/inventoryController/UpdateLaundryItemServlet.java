package inventoryController;

import inventoryModel.InventoryItem;
import inventoryService.InventoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateLaundryItemServlet extends HttpServlet {

    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        InventoryItem item = inventoryDAO.getLaundryItemById(id);
        request.setAttribute("item", item);
        request.getRequestDispatcher("/views/inventory/updateLaundryItem.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        InventoryItem item = new InventoryItem(id, itemName, quantity);
        inventoryDAO.updateLaundryItem(item);

        response.sendRedirect("LaundryInventoryServlet");
    }
}
