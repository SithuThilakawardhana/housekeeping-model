package inventoryController;

import inventoryModel.LaundryTransaction;
import inventoryService.InventoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LaundryTransactionReportServlet extends HttpServlet {

    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<LaundryTransaction> transactions = inventoryDAO.getLaundryTransactions();
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("views/inventory/laundryTransactionReport.jsp").forward(request, response);
    }
}
