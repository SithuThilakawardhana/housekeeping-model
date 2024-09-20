package inventoryController;

import inventoryService.InventoryDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LaundryTransactionServlet extends HttpServlet {

    private InventoryDAO inventoryDAO;

    public void init() {
        inventoryDAO = new InventoryDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int towelQuantity = Integer.parseInt(request.getParameter("towel_quantity"));
    int bedsheetQuantity = Integer.parseInt(request.getParameter("bedsheet_quantity"));
    int pillowcaseQuantity = Integer.parseInt(request.getParameter("pillowcase_quantity"));
    int blanketQuantity = Integer.parseInt(request.getParameter("blanket_quantity"));
    String status = request.getParameter("status");
    String date = request.getParameter("date");

    // Log the form data received
    System.out.println("Laundry Transaction - Towels: " + towelQuantity + ", Bedsheets: " + bedsheetQuantity 
                        + ", Pillowcases: " + pillowcaseQuantity + ", Blankets: " + blanketQuantity);
    System.out.println("Transaction Status: " + status + ", Date: " + date);

    try {
        if ("Sent".equals(status)) {
            System.out.println("Updating laundry inventory after sent...");
            inventoryDAO.updateLaundryInventoryAfterSent(towelQuantity, bedsheetQuantity, pillowcaseQuantity, blanketQuantity);
        } else if ("Returned".equals(status)) {
            System.out.println("Updating fresh linen inventory after return...");
            inventoryDAO.updateFreshLinenInventoryAfterReturn(towelQuantity, bedsheetQuantity, pillowcaseQuantity, blanketQuantity);
        }

        // Record the transaction in the laundry_transactions table
        System.out.println("Recording transaction...");
        inventoryDAO.recordLaundryTransaction(towelQuantity, bedsheetQuantity, pillowcaseQuantity, blanketQuantity, date, status);

        response.sendRedirect("LaundryInventoryServlet");
    } catch (Exception e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the laundry transaction.");
    }
}


}
