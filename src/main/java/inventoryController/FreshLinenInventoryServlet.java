package inventoryController;

import inventoryModel.InventoryItem;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;
import inventoryService.InventoryDAO;

public class FreshLinenInventoryServlet extends HttpServlet {
    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<InventoryItem> freshLinenItems = inventoryDAO.getFreshLinenInventory();
        request.setAttribute("freshLinenItems", freshLinenItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/inventory/freshLinenInventory.jsp");
        dispatcher.forward(request, response);
    }
}
