package inventoryController;

import inventoryModel.InventoryItem;
import inventoryService.InventoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToiletriesItemServlet extends HttpServlet {
    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Use the constructor for adding new items (without ID)
        InventoryItem item = new InventoryItem(itemName, quantity);
        inventoryDAO.addToiletriesItem(item);

        // Redirect to the toiletries inventory list after adding
        response.sendRedirect("ToiletriesInventoryServlet");
    }
}
