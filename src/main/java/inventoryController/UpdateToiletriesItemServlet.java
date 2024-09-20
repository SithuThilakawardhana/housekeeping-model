package inventoryController;

import inventoryModel.InventoryItem;
import inventoryService.InventoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateToiletriesItemServlet extends HttpServlet {

    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id"); // Get the id parameter from the request

        if (idParam == null || idParam.isEmpty()) {
            // Handle the error if id is missing or empty
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Item ID is missing.");
            return;
        }

        try {
            // Parse the id parameter to an integer
            int itemId = Integer.parseInt(idParam);

            // Fetch the item by ID
            InventoryItem item = inventoryDAO.getToiletriesItemById(itemId);

            if (item != null) {
                request.setAttribute("item", item);  // Pass the item to the JSP
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Item not found.");
                return;
            }

            // Forward to JSP
            request.getRequestDispatcher("/views/inventory/updateToiletriesItem.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle invalid id format
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid item ID format.");
        }
    }

    // Handle POST request for updating item
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Update the item using DAO
        InventoryItem item = new InventoryItem(id, itemName, quantity);
        inventoryDAO.updateToiletriesItem(item);

        // Redirect to the toiletries inventory page after update
        response.sendRedirect("ToiletriesInventoryServlet");
    }
}
