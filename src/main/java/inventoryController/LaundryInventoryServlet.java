package inventoryController;

import inventoryModel.InventoryItem;
import inventoryService.InventoryDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

public class LaundryInventoryServlet extends HttpServlet {
    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<InventoryItem> laundryItems = inventoryDAO.getLaundryInventory();
        request.setAttribute("laundryItems", laundryItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/inventory/laundryInventory.jsp");
        dispatcher.forward(request, response);
    }
}
