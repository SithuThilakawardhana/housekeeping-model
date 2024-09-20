package inventoryController;

import inventoryService.InventoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteToiletriesItemServlet extends HttpServlet {
    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Item ID is missing.");
            return;
        }

        try {
            int itemId = Integer.parseInt(idParam);
            inventoryDAO.deleteToiletriesItemById(itemId);
            response.sendRedirect("ToiletriesInventoryServlet"); // Redirect after deletion
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid item ID.");
        }
    }
}
