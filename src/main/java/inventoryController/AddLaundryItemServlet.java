package inventoryController;

import inventoryModel.InventoryItem;
import inventoryService.InventoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddLaundryItemServlet extends HttpServlet {
    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        InventoryItem item = new InventoryItem(itemName, quantity);
        inventoryDAO.addLaundryItem(item);

        response.sendRedirect("LaundryInventoryServlet");
    }
}
